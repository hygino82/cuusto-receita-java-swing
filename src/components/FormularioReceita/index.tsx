import { useState } from "react";

export function FormularioReceita() {
    const [custo, setCusto] = useState(0.0);
    const [nome, setNome] = useState('');
    const [descricao, setDescricao] = useState('');
    const [embalagem, setEmbalagem] = useState('KG');
    const [utilizada, setUtilizada] = useState('KG');
    const [tipo, setTipo] = useState('solido');


    function tipoIngrediente(e: any) {
        e.preventDefault();
        setTipo(e.target.value)
    }

    return (
        <>
            <form>
                <h3>Formulário de receita</h3>
                <label htmlFor="nome" id="nome">Nome</label>
                <input type="text" required value={nome} /><br />
                <label htmlFor="descricao">Descricao</label>
                <input type="text" id="descricao" required value={descricao} /><br />
                <select className="form-select" aria-label="Default select example">
                    <option selected value='solido'>Sólido</option>
                    <option value="liquido">Líquido</option>
                </select>
                <label htmlFor="preco-embalagem">Preço embalagem</label>
                <input type="number" id="preco-embalagem" /><br />
                <select className="form-select" aria-label="Default select example" onChange={tipoIngrediente}>
                    <option selected value={(tipo == 'solido') ? 'KG' : 'L'}>{tipo.toUpperCase()}</option>
                    <option value="liquido" defaultValue={(tipo == 'solido') ? 'G' : 'ML'}>{tipo.toUpperCase()}</option>
                </select>
                <label htmlFor="quantidade-embalagem">Quantidade embalagem</label>
                <input type="number" id="quantidade-embalagem" /><br />
                <label htmlFor="quantidade-utilizada">Quantidade utilizada</label>
                <input type="number" id="quantidade-utilizada" /><br />
                <button type="submit" className="btn btn-primary">Adicionar</button>
            </form>
            <h2>Custo total R${custo.toFixed(2)}</h2>
        </>
    );
}