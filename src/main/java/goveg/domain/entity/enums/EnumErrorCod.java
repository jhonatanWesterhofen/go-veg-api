package goveg.domain.entity.enums;

public enum EnumErrorCod implements IEnum {

        
        USUARIO_EXISTENTE("001", "Usuário inexistente na base de dados!", 400),
        EMAIL_INVALIDO("002", "E-mail informado inválido!", 400),
        DOCUMENTO_INVALIDO("003", "Documento informado é inválido. Precisa ser um número de CPF ou CNPJ válido!", 400),
        ERRO_PARSER("004", "Erro ao converter a informação passada", 400),
        EMAIL_JA_EXISTENTE("005", "Já existe uma conta vinculada a este e-mail.", 400),
        TELEFONE_JA_EXISTENTE("006", "Já existe uma conta vinculada a este telefone.", 400),
        CONTA_INEXISTENTE_NA_CREDENCIAL("007", "Conta inválida para as credenciais informadas.", 404),
        EMPRESA_JA_CADASTRADA("009", "Empresa com CNPJ informado já está em processo de criação de conta.", 400),
        TOKEN_NAO_INFORMADO("010", "Nenhum token foi informado na requisição.", 400),
        TOKEN_INCORRETO("011", "Token informado incorreto.", 400),
        DATA_INFORMADA_INVALIDA("012", "Data informada não respeita o formato padrão.", 400),
        SENHA_INVALIDA("013", "Senha inválida!", 400),
        ERRO_COMUNICACAO("014", "A requisição enviada ao parceiro retornou com erro!", 502),
        OBJETO_OBRIGATORIO("015", "O objeto {0} é obrigatório!", 400),
        CAMPO_OBRIGATORIO("016", "O campo {0} é obrigatório", 400),
        FORMATO_INVALIDO_DO_CAMPO("017", "O campo aceita somente numeros", 400),
        DOCUMENTO_INFORMADO_INVALIDO("018", "O documento informado é invalido!", 400);

        private final String key, error;
        private final int httpStatus;

        private EnumErrorCod(String key, String error, int httpStatus) {
                this.key = key;
                this.error = error;
                this.httpStatus = httpStatus;
        }

        @Override
        public String getKey() {
                return key;
        }

        public String getError() {
                return error;
        }

        public int getHttpStatus() {
                return httpStatus;
        }

        @Override
        public boolean containsInEnum(String key) {
                return false;
        }

      

}
