
document.addEventListener('DOMContentLoaded', function() {
    
    initTipsFilter();
    initSmoothScrolling();
    initAnimations();
    initAutoRefresh();
    
    function initTipsFilter() {
        const filterButtons = document.querySelectorAll('.filter-btn');
        const tipCards = document.querySelectorAll('.tip-card');
        
        if (filterButtons.length === 0 || tipCards.length === 0) return;
        
        filterButtons.forEach(button => {
            button.addEventListener('click', function() {
                const category = this.getAttribute('data-category');
                
                filterButtons.forEach(btn => btn.classList.remove('active'));
                
                this.classList.add('active');
                
                tipCards.forEach(card => {
                    const cardCategory = card.getAttribute('data-category');
                    
                    if (category === 'all' || cardCategory === category) {
                        card.style.display = 'flex';
                        card.style.animation = 'fadeIn 0.6s ease-out';
                    } else {
                        card.style.display = 'none';
                    }
                });
            });
        });
    }
    
    function initSmoothScrolling() {
        const links = document.querySelectorAll('a[href^="#"]');
        
        links.forEach(link => {
            link.addEventListener('click', function(e) {
                e.preventDefault();
                
                const targetId = this.getAttribute('href').substring(1);
                const targetElement = document.getElementById(targetId);
                
                if (targetElement) {
                    targetElement.scrollIntoView({
                        behavior: 'smooth',
                        block: 'start'
                    });
                }
            });
        });
    }
    
    function initAnimations() {
        const observerOptions = {
            threshold: 0.1,
            rootMargin: '0px 0px -50px 0px'
        };
        
        const observer = new IntersectionObserver(function(entries) {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    entry.target.style.opacity = '1';
                    entry.target.style.transform = 'translateY(0)';
                }
            });
        }, observerOptions);
        
        const animatedElements = document.querySelectorAll('.tip-card, .info-card, .result-card, .feature-item, .pollutant-card');
        
        animatedElements.forEach(element => {
            element.style.opacity = '0';
            element.style.transform = 'translateY(20px)';
            element.style.transition = 'opacity 0.6s ease-out, transform 0.6s ease-out';
            observer.observe(element);
        });
    }
    
    function initAutoRefresh() {
        const airQualityData = document.querySelector('.air-quality-card');
        
        if (!airQualityData) return;
        
        const timestamp = document.querySelector('.timestamp');
        if (timestamp) {
            setInterval(updateTimestamp, 60000); 
        }
        
    }
    
    function updateTimestamp() {
        const timestamp = document.querySelector('.timestamp');
        if (!timestamp) return;
        
        const timestampText = timestamp.textContent;
        const timeMatch = timestampText.match(/(\d{2}\/\d{2}\/\d{4} \d{2}:\d{2})/);
        
        if (timeMatch) {
            const updateTime = new Date(timeMatch[1].replace(/(\d{2})\/(\d{2})\/(\d{4})/, '$3-$2-$1'));
            const now = new Date();
            const diffMinutes = Math.floor((now - updateTime) / (1000 * 60));
            
            let relativeTime;
            if (diffMinutes < 1) {
                relativeTime = 'Agora mesmo';
            } else if (diffMinutes < 60) {
                relativeTime = `${diffMinutes} minuto${diffMinutes > 1 ? 's' : ''} atrás`;
            } else {
                const diffHours = Math.floor(diffMinutes / 60);
                relativeTime = `${diffHours} hora${diffHours > 1 ? 's' : ''} atrás`;
            }
            
            timestamp.textContent = `Atualizado ${relativeTime}`;
        }
    }
    
    function refreshAirQualityData(city) {
        
        console.log(`Atualizando dados para ${city}...`);
        
    }
    
    function updateAirQualityDisplay(data) {
        
        const aqiValue = document.querySelector('.aqi-value');
        const aqiStatus = document.querySelector('.status');
        const recommendation = document.querySelector('.recommendation');
        
        if (aqiValue) aqiValue.textContent = data.aqi;
        if (aqiStatus) aqiStatus.textContent = data.status;
        if (recommendation) recommendation.textContent = data.healthRecommendation;
        
        const pollutants = ['pm25', 'pm10', 'o3', 'no2', 'so2', 'co'];
        pollutants.forEach(pollutant => {
            const element = document.querySelector(`[data-pollutant="${pollutant}"] .value`);
            if (element && data[pollutant]) {
                const unit = pollutant === 'co' ? 'mg/m³' : 'μg/m³';
                element.textContent = `${data[pollutant].toFixed(1)} ${unit}`;
            }
        });
        
        const aqiCircle = document.querySelector('.aqi-circle');
        if (aqiCircle) {
        
            aqiCircle.classList.remove('good', 'moderate', 'unhealthy-sensitive', 'unhealthy', 'very-unhealthy', 'hazardous');
            
            if (data.aqi <= 50) {
                aqiCircle.classList.add('good');
            } else if (data.aqi <= 100) {
                aqiCircle.classList.add('moderate');
            } else if (data.aqi <= 150) {
                aqiCircle.classList.add('unhealthy-sensitive');
            } else if (data.aqi <= 200) {
                aqiCircle.classList.add('unhealthy');
            } else if (data.aqi <= 300) {
                aqiCircle.classList.add('very-unhealthy');
            } else {
                aqiCircle.classList.add('hazardous');
            }
        }
        
        const timestamp = document.querySelector('.timestamp');
        if (timestamp) {
            const now = new Date();
            const formattedTime = now.toLocaleString('pt-BR');
            timestamp.textContent = `Atualizado em: ${formattedTime}`;
        }
    }
    
    const buttons = document.querySelectorAll('.search-btn, .cta-button, .filter-btn');
    buttons.forEach(button => {
        button.addEventListener('mouseenter', function() {
            this.style.transform = 'translateY(-2px)';
        });
        
        button.addEventListener('mouseleave', function() {
            this.style.transform = 'translateY(0)';
        });
    });
    
    const searchForm = document.querySelector('.search-form');
    if (searchForm) {
        searchForm.addEventListener('submit', function() {
            const submitButton = this.querySelector('.search-btn');
            if (submitButton) {
                submitButton.innerHTML = '<i class="fas fa-spinner fa-spin"></i> Buscando...';
                submitButton.disabled = true;
            }
        });
    }
    
    const pollutantCards = document.querySelectorAll('.pollutant-card');
    pollutantCards.forEach(card => {
        const pollutantName = card.querySelector('h4').textContent;
        let tooltipText = '';
        
        switch(pollutantName) {
            case 'PM2.5':
                tooltipText = 'Partículas finas que podem penetrar profundamente nos pulmões';
                break;
            case 'PM10':
                tooltipText = 'Partículas inaláveis que podem causar problemas respiratórios';
                break;
            case 'O₃':
                tooltipText = 'Ozônio troposférico, pode causar irritação respiratória';
                break;
            case 'NO₂':
                tooltipText = 'Dióxido de nitrogênio, principalmente de veículos e indústrias';
                break;
            case 'SO₂':
                tooltipText = 'Dióxido de enxofre, principalmente de queima de combustíveis fósseis';
                break;
            case 'CO':
                tooltipText = 'Monóxido de carbono, gás incolor e inodoro muito perigoso';
                break;
        }
        
        if (tooltipText) {
            card.title = tooltipText;
        }
    });
    
    function addShareFunctionality() {
        const shareButton = document.createElement('button');
        shareButton.innerHTML = '<i class="fas fa-share-alt"></i> Compartilhar';
        shareButton.className = 'share-btn';
        shareButton.style.cssText = `
            position: fixed;
            bottom: 20px;
            right: 20px;
            background: linear-gradient(135deg, var(--primary-blue), var(--secondary-blue));
            color: white;
            border: none;
            padding: 1rem;
            border-radius: 50px;
            cursor: pointer;
            box-shadow: 0 4px 15px rgba(37, 99, 235, 0.3);
            z-index: 1000;
            display: none;
        `;
        
        shareButton.addEventListener('click', function() {
            if (navigator.share) {
                navigator.share({
                    title: 'Monitor de Qualidade do Ar',
                    text: 'Confira a qualidade do ar na sua cidade!',
                    url: window.location.href
                });
            } else {
                const url = window.location.href;
                navigator.clipboard.writeText(url).then(() => {
                    alert('Link copiado para a área de transferência!');
                });
            }
        });
        
        if (document.querySelector('.air-quality-card')) {
            document.body.appendChild(shareButton);
            shareButton.style.display = 'block';
        }
    }
    
    addShareFunctionality();
    
    console.log('AirMonitor JavaScript inicializado com sucesso!');
});

