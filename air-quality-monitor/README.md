# Monitor de Qualidade do Ar - AirMonitor

## Descrição do Projeto

O AirMonitor é uma aplicação web desenvolvida em Java com Spring Boot que permite o monitoramento da qualidade do ar em tempo real para diversas cidades brasileiras. A aplicação também fornece dicas educativas para melhorar a qualidade do ar e promover práticas sustentáveis.

## Funcionalidades Implementadas

### 1. Monitoramento da Qualidade do Ar
- Seleção de cidade através de dropdown
- Exibição do Índice de Qualidade do Ar (AQI)
- Classificação da qualidade (Boa, Moderada, Insalubre, etc.)
- Detalhamento de poluentes (PM2.5, PM10, O₃, NO₂, SO₂, CO)
- Recomendações de saúde baseadas no AQI
- Timestamp da última atualização

### 2. Sistema de Dicas Sustentáveis
- Mais de 15 dicas organizadas por categoria
- Filtros por categoria (Transporte, Energia, Doméstico, Reciclagem, Comunidade)
- Interface interativa com JavaScript
- Seção de impacto positivo com estatísticas

### 3. Página Informativa
- Descrição da missão e objetivos do projeto
- Metodologia utilizada
- Tecnologias empregadas
- Resultados esperados
- Plano de manutenção evolutiva

## Arquitetura Técnica

### Backend (Java Spring Boot)
- **Framework**: Spring Boot 2.7.18
- **Linguagem**: Java 11
- **Template Engine**: Thymeleaf
- **Build Tool**: Maven
- **Arquitetura**: MVC (Model-View-Controller)

### Frontend
- **HTML5** com templates Thymeleaf
- **CSS3** com design responsivo
- **JavaScript** para interatividade
- **Font Awesome** para ícones
- **Esquema de cores**: Azul, Branco e Preto

### Estrutura do Projeto
```
src/
├── main/
│   ├── java/com/airquality/monitor/
│   │   ├── AirQualityMonitorApplication.java
│   │   ├── controller/
│   │   │   ├── HomeController.java
│   │   │   └── ApiController.java
│   │   ├── model/
│   │   │   ├── AirQualityData.java
│   │   │   └── Tip.java
│   │   └── service/
│   │       ├── AirQualityService.java
│   │       └── TipService.java
│   └── resources/
│       ├── templates/
│       │   ├── index.html
│       │   ├── tips.html
│       │   └── about.html
│       ├── static/
│       │   ├── css/style.css
│       │   └── js/script.js
│       └── application.properties
```

## Como Executar

### Pré-requisitos
- Java 11 ou superior
- Maven 3.6+

### Passos para Execução
1. Extrair o arquivo ZIP
2. Navegar até o diretório do projeto
3. Executar: `mvn clean compile`
4. Executar: `mvn spring-boot:run`
5. Acessar: http://localhost:8080

### Endpoints Disponíveis
- **GET /** - Página principal
- **POST /search** - Busca dados de qualidade do ar
- **GET /tips** - Página de dicas sustentáveis
- **GET /about** - Página sobre o projeto
- **GET /api/air-quality/{city}** - API REST para dados de qualidade do ar
- **GET /api/tips** - API REST para todas as dicas
- **GET /api/tips/{category}** - API REST para dicas por categoria

## Simulação de Dados

Como esta é uma aplicação de demonstração, os dados de qualidade do ar são simulados com base em características típicas de cada cidade brasileira. Em um ambiente de produção, estes dados seriam obtidos através de APIs reais como:
- Google Maps Air Quality API
- OpenWeatherMap Air Pollution API
- APIs governamentais de monitoramento ambiental

## Cidades Suportadas

- São Paulo
- Rio de Janeiro
- Belo Horizonte
- Salvador
- Brasília
- Curitiba
- Fortaleza
- Manaus
- Recife
- Porto Alegre

## Design e UX

### Esquema de Cores
- **Azul Primário**: #2563eb
- **Azul Secundário**: #3b82f6
- **Azul Claro**: #dbeafe
- **Preto**: #000000
- **Cinza Escuro**: #1f2937
- **Branco**: #ffffff

### Características do Design
- Design responsivo para desktop e mobile
- Navegação intuitiva com menu fixo
- Cards informativos com hover effects
- Gradientes e sombras para profundidade
- Ícones Font Awesome para melhor UX
- Animações suaves com CSS e JavaScript

## Funcionalidades JavaScript

- Filtro dinâmico de dicas por categoria
- Animações de scroll
- Efeitos de hover interativos
- Sistema de compartilhamento (preparado para implementação)
- Auto-refresh de dados (preparado para implementação)
- Timestamps relativos

## APIs REST

A aplicação inclui endpoints REST para integração futura:

### GET /api/air-quality/{city}
Retorna dados de qualidade do ar para uma cidade específica.

**Exemplo de resposta:**
```json
{
  "aqi": 83,
  "pm25": 25.3,
  "pm10": 27.6,
  "o3": 162.7,
  "no2": 71.0,
  "so2": 32.8,
  "co": 8.4,
  "city": "São Paulo",
  "status": "Moderada",
  "healthRecommendation": "A qualidade do ar é aceitável...",
  "timestamp": "15/06/2024 20:43"
}
```

### GET /api/tips
Retorna todas as dicas sustentáveis.

### GET /api/tips/{category}
Retorna dicas filtradas por categoria.

## Considerações de Segurança

- Validação de entrada nos formulários
- Sanitização de dados
- Headers de segurança configurados
- CORS configurado para APIs REST

## Performance

- CSS e JavaScript minificados em produção
- Imagens otimizadas
- Lazy loading preparado para implementação
- Cache de dados simulados
- Compressão gzip habilitada

## Acessibilidade

- Estrutura semântica HTML5
- Labels apropriados para formulários
- Contraste adequado de cores
- Navegação por teclado suportada
- Textos alternativos para ícones

## Testes Realizados

### Testes Funcionais
✅ Seleção de cidade e busca de dados
✅ Exibição correta dos dados de qualidade do ar
✅ Navegação entre páginas
✅ Filtros de categoria nas dicas
✅ Responsividade em diferentes tamanhos de tela

### Testes de Integração
✅ Comunicação entre controllers e services
✅ Renderização correta dos templates Thymeleaf
✅ Funcionamento das APIs REST

### Testes de Interface
✅ Design conforme especificações (azul, branco, preto)
✅ Interatividade JavaScript
✅ Animações e efeitos visuais

## Próximos Passos

Para evolução do projeto, consulte o documento "PLANO_MANUTENCAO_EVOLUTIVA.md" incluído no projeto.

## Suporte

Para dúvidas ou problemas, consulte a documentação técnica ou entre em contato com a equipe de desenvolvimento.

---

**Desenvolvido com ❤️ para conscientização ambiental**

