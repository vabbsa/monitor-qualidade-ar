package com.airquality.monitor.service;

import com.airquality.monitor.model.Tip;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipService {
    
    private final List<Tip> tips;
    
    public TipService() {
        this.tips = initializeTips();
    }
    
    public List<Tip> getAllTips() {
        return new ArrayList<>(tips);
    }
    
    public List<Tip> getTipsByCategory(String category) {
        return tips.stream()
                .filter(tip -> tip.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }
    
    private List<Tip> initializeTips() {
        List<Tip> tipList = new ArrayList<>();
        
        // Dicas de Transporte
        tipList.add(new Tip(
            "Use Transporte Público",
            "Prefira ônibus, metrô ou trem em vez do carro particular. O transporte público reduz significativamente as emissões de poluentes por pessoa.",
            "Transporte",
            "🚌"
        ));
        
        tipList.add(new Tip(
            "Ande de Bicicleta",
            "A bicicleta é uma excelente alternativa para trajetos curtos e médios. Além de não poluir, faz bem para sua saúde.",
            "Transporte",
            "🚴"
        ));
        
        tipList.add(new Tip(
            "Compartilhe Caronas",
            "Organize caronas com colegas de trabalho ou use aplicativos de carona compartilhada. Menos carros nas ruas significa menos poluição.",
            "Transporte",
            "🚗"
        ));
        
        tipList.add(new Tip(
            "Trabalhe de Casa",
            "Quando possível, trabalhe remotamente. Isso reduz a necessidade de deslocamento e consequentemente as emissões de poluentes.",
            "Transporte",
            "🏠"
        ));
        
        // Dicas de Energia
        tipList.add(new Tip(
            "Use Lâmpadas LED",
            "Substitua lâmpadas incandescentes por LED. Elas consomem menos energia e duram mais tempo, reduzindo a demanda por energia elétrica.",
            "Energia",
            "💡"
        ));
        
        tipList.add(new Tip(
            "Desligue Aparelhos",
            "Desligue completamente aparelhos eletrônicos quando não estiver usando. O modo standby ainda consome energia.",
            "Energia",
            "🔌"
        ));
        
        tipList.add(new Tip(
            "Use Energia Solar",
            "Considere instalar painéis solares em casa. A energia solar é limpa e renovável, reduzindo a dependência de fontes poluentes.",
            "Energia",
            "☀️"
        ));
        
        // Dicas Domésticas
        tipList.add(new Tip(
            "Evite Queimar Lixo",
            "Nunca queime lixo ou folhas secas. A queima libera gases tóxicos que poluem o ar. Prefira a compostagem para resíduos orgânicos.",
            "Doméstico",
            "🔥"
        ));
        
        tipList.add(new Tip(
            "Plante Árvores",
            "Plante árvores e mantenha plantas em casa. Elas absorvem CO2 e liberam oxigênio, melhorando a qualidade do ar.",
            "Doméstico",
            "🌳"
        ));
        
        tipList.add(new Tip(
            "Use Produtos Ecológicos",
            "Prefira produtos de limpeza biodegradáveis e com menos químicos. Eles são menos nocivos ao meio ambiente.",
            "Doméstico",
            "🧽"
        ));
        
        tipList.add(new Tip(
            "Reduza o Consumo",
            "Compre apenas o necessário. Menos consumo significa menos produção industrial e consequentemente menos poluição.",
            "Doméstico",
            "🛒"
        ));
        
        // Dicas Industriais/Comunitárias
        tipList.add(new Tip(
            "Separe o Lixo",
            "Faça a separação correta do lixo para reciclagem. Isso reduz a necessidade de produção de novos materiais.",
            "Reciclagem",
            "♻️"
        ));
        
        tipList.add(new Tip(
            "Participe de Ações Comunitárias",
            "Engaje-se em ações de conscientização ambiental na sua comunidade. A mudança coletiva é mais efetiva.",
            "Comunidade",
            "👥"
        ));
        
        tipList.add(new Tip(
            "Monitore a Qualidade do Ar",
            "Acompanhe regularmente os índices de qualidade do ar da sua região e ajuste suas atividades conforme necessário.",
            "Monitoramento",
            "📊"
        ));
        
        tipList.add(new Tip(
            "Evite Exercícios ao Ar Livre em Dias Poluídos",
            "Em dias com alta poluição, prefira exercitar-se em ambientes fechados para evitar inalação excessiva de poluentes.",
            "Saúde",
            "🏃"
        ));
        
        return tipList;
    }
}

