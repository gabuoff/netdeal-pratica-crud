class Colaborador {
    constructor(data) {
        this.nome = data.nome || '';
        this.senha = data.senha || '';
        this.cargo = data.cargo || '';
        this.forcaDaSenha = data.forcaDaSenha || '';
        this.hierarquia = data.hierarquia || '';
    }
}
