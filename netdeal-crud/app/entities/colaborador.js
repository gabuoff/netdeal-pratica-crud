class Colaborador {
    constructor(data) {
        this.nome = data.nome || '';
        this.senha = data.senha || '';
        this.cargo = data.cargo || '';
        this.hierarquia = data.hierarquia || '';
    }
}
