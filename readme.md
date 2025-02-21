Agendador de Notificações
Esse projeto foi desenvolvido para um desafio técnico visando apresentar habilidades de desenvolvedor java backend e tem como escopo o cadastro de notificações para posterior envio.

Rodando localmente
Clone o projeto

git clone https://link-para-o-projeto
Entre no diretório do projeto

docker-compose up --build
Documentação da API
Cadastra notificações pendentes
POST /agendamento
Body	Tipo	Descrição
emailDestinatario	string	Obrigatório. Email do destinatário da notificação
telefoneDestinatario	string	Obrigatório. Telefone do destinatário da notificação
mensagem	string	Obrigatório. Mensagem da notificação
dataHoraEvento	LocalDateTime	Obrigatório. Data hora do evento no formado dd-MM-yyyy HH:mm:ss
Retorna uma notificação por id
GET /agendamento/${id}
Parâmetro	Tipo	Descrição
id	string	Obrigatório. O ID do item que você quer buscar
Cancela uma notificação por id
DELETE /agendamento/${id}
Parâmetro	Tipo	Descrição
id	string	Obrigatório. O ID do item que você quer cancelar
Rodando os testes
Para rodar os testes, rode o seguinte comando

mvn test
