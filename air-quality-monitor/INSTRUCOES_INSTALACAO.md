# Instruções de Instalação e Execução - AirMonitor

## Pré-requisitos

### Software Necessário
- **Java 11 ou superior**
  - Download: https://adoptium.net/
  - Verificar instalação: `java -version`

- **Maven 3.6 ou superior**
  - Download: https://maven.apache.org/download.cgi
  - Verificar instalação: `mvn -version`

### Sistemas Operacionais Suportados
- Windows 10/11
- macOS 10.14+
- Linux (Ubuntu 18.04+, CentOS 7+)

## Instalação

### Passo 1: Extrair o Projeto
```bash
# Extrair o arquivo ZIP
unzip air-quality-monitor.zip

# Navegar para o diretório
cd air-quality-monitor
```

### Passo 2: Compilar o Projeto
```bash
# Limpar e compilar
mvn clean compile

# Ou compilar e executar testes (opcional)
mvn clean test
```

### Passo 3: Executar a Aplicação
```bash
# Executar com Maven
mvn spring-boot:run

# Ou gerar JAR e executar
mvn clean package
java -jar target/air-quality-monitor-0.0.1-SNAPSHOT.jar
```

### Passo 4: Acessar a Aplicação
- Abrir navegador em: http://localhost:8080
- A aplicação estará disponível imediatamente

## Configurações Opcionais

### Alterar Porta do Servidor
Editar `src/main/resources/application.properties`:
```properties
server.port=8081
```

### Configurar Logs
Adicionar ao `application.properties`:
```properties
logging.level.com.airquality.monitor=DEBUG
logging.file.name=logs/airmonitor.log
```

## Estrutura do Projeto

```
air-quality-monitor/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/airquality/monitor/
│   │   │       ├── AirQualityMonitorApplication.java
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       └── service/
│   │   └── resources/
│   │       ├── templates/
│   │       ├── static/
│   │       └── application.properties
├── target/
├── pom.xml
├── README.md
├── PLANO_MANUTENCAO_EVOLUTIVA.md
└── INSTRUCOES_INSTALACAO.md
```

## Funcionalidades Disponíveis

### 1. Página Principal (/)
- Seleção de cidade
- Consulta de qualidade do ar
- Exibição de dados em tempo real

### 2. Página de Dicas (/tips)
- Dicas sustentáveis organizadas por categoria
- Filtros interativos
- Estatísticas de impacto

### 3. Página Sobre (/about)
- Informações sobre o projeto
- Metodologia utilizada
- Objetivos e resultados esperados

### 4. APIs REST
- `/api/air-quality/{city}` - Dados de qualidade do ar
- `/api/tips` - Todas as dicas
- `/api/tips/{category}` - Dicas por categoria

## Solução de Problemas

### Erro: "Java version not supported"
- Verificar se Java 11+ está instalado
- Configurar JAVA_HOME se necessário

### Erro: "Maven command not found"
- Instalar Maven ou usar wrapper incluído
- Verificar PATH do sistema

### Erro: "Port 8080 already in use"
- Alterar porta no application.properties
- Ou parar processo que usa a porta 8080

### Erro de Compilação
```bash
# Limpar cache do Maven
mvn clean

# Recompilar
mvn compile
```

## Desenvolvimento

### Executar em Modo de Desenvolvimento
```bash
# Com hot reload
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.devtools.restart.enabled=true"
```

### Executar Testes
```bash
# Todos os testes
mvn test

# Testes específicos
mvn test -Dtest=AirQualityServiceTest
```

### Gerar Relatório de Cobertura
```bash
mvn jacoco:report
# Relatório em: target/site/jacoco/index.html
```

## Deploy em Produção

### Gerar JAR Executável
```bash
mvn clean package -DskipTests
```

### Executar em Produção
```bash
java -jar -Dspring.profiles.active=prod target/air-quality-monitor-0.0.1-SNAPSHOT.jar
```

### Configurações de Produção
Criar `application-prod.properties`:
```properties
server.port=80
logging.level.root=WARN
logging.file.name=/var/log/airmonitor/app.log
```

## Monitoramento

### Health Check
- URL: http://localhost:8080/actuator/health
- Retorna status da aplicação

### Métricas
- URL: http://localhost:8080/actuator/metrics
- Métricas de performance

## Backup e Manutenção

### Logs da Aplicação
- Localização: `logs/` (se configurado)
- Rotação automática recomendada

### Atualizações
1. Fazer backup da configuração atual
2. Substituir arquivos da aplicação
3. Reiniciar o serviço
4. Verificar funcionamento

## Suporte

### Documentação Adicional
- README.md - Documentação completa
- PLANO_MANUTENCAO_EVOLUTIVA.md - Roadmap futuro

### Contato
- Para suporte técnico, consulte a documentação
- Para bugs, verifique logs da aplicação

---

**AirMonitor v1.0.0**  
**Desenvolvido para conscientização ambiental**

