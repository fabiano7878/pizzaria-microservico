# pizzaria-microservico usando Spring Boot
Tento simular uma pizzaria nacional, onde a loja pode disparar pedidos a forncedores de outros estados, conforme escolha do cliente, também estudo
como trabalhar no ambiente de microserviço e um dos metodos de configurar a comunicação entre eles e gerenciamento de acessos.

obs.: o diretório "\pizzaria-microservico\microservice-repo\fornecedor.yml" está presente, caso queira usar a configuração de banco de dados no ambiente que esta o micro serviço e não no github como foi feito na parte final com a evoluação do preojto.


# restTemplate
Para ustilização de comnuição de protocolo http de alto nivel, comunicação REST

# Spring Feign
Aprimorando a aplicação, ele fornece designe aprimorado através de interface para realizarmos as chamadas dos microserviçõs externos e também tem a impleemntação do Ribbon que fornece o load balance.
Nos ajuda a criar chamdas via REST para outro microserviço.


# Eureka
Um introdução ao Service discovery e Service registry
Service registry é um servidor central, onde todos os microsserviços ficam cadastrados (nome e IP/porta)
Service discovery é um mecanismo de descoberta do IP do microsserviço pelo nome
Dessa forma, nenhum microsserviço fica acoplado ao outro pelo IP/porta
A resolução do IP/porta através do nome do microsserviço nas requisições
Gerenciamento dos acessos dos microserviços, resolução de dominios, nele eu defino as informações de como cada microserviço encontra o destino de sua
requisição em outro microserviço pela rede.

# SpringConfig
Que o Spring Config Server é uma implementação do servidor do projeto Spring Cloud
Coinfigurei este serviço como centralizador das configurações de base, ele vai fornceer incialmente toda configuração externa para os microservições de
forma centralizada. Ou seja, o acesso a base de dados do microserviço de forncedor, esta externalizada no ambiente padrão, e está no github, caso precise
que seja de outro ambiente eu configuro o arquivo para o ambiente epsecifico e todas as instancias vão usar essa configuração.

# repository
Usei o conceito de repositórie para configuração das instancias que comunicam com a base de dados no Java, e a configuração dessas fica no Config server e acessada pela biblioteca Scpring client, que le um repository criado no github.

# Log4J - logback
Usei a implementação para gerar os logs e fazer a rastreabilidade dos microserviços

# Spring Sleuth
Facilita para organizar as chamadas dos logs, gerando um id facilitando a rastreabilidade dos registros, configurando no logback.

# Papertrail
Usei a configuração junto com a do log4j, no logback, para enviar para o parpertrail os logs gerados e unificar em um lugar só e online.


# Hystrix
Usei o Hystrix, habilitando o circuit brakercaso há falhas no processo da requisição de compra, usei no metodo realiza compra.
Com Hystrix também trato o Fallback, através do metodo "realizaCompraFallBack."


# Bulkhead de theads com o Hystrix
Neste exemplo entendo como funciona o compartilhamento de theads, o Hystrix consegue liberar 10 threads para cada
funcionalida, no caso na classe "compraService" temos a funcionalidade de findByIB e "realizaComrpa", e as threads foram compartilhadas adequadamente.


# usando Stream Java 8
Usei em alguns caso a API stream, muito enxuta mas dificulta no entendimento e quando performace em casos bem pontuais, aparenta ser ok.