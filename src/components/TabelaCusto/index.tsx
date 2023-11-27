import { Ingrediente } from "../../types/receita-tipos";
import { CustoTotal } from "../../utils/valores";

export function TabelaCusto() {

    const ingredientes: Ingrediente[] = [
        {
            nome: 'Açúcar cristal',
            precoEmbalagem: 21.59,
            quantidadeEmbalagem: 5,
            quantidadeUtilizada: 0.3,
            custo: 1.30,
            id: 1,
            tipo: "sólido",
            unidade: "Kg"
        },
        {
            nome: 'Fubá',
            precoEmbalagem: 3.60,
            quantidadeEmbalagem: 1,
            quantidadeUtilizada: 0.3,
            custo: 1.80,
            id: 2,
            tipo: "sólido",
            unidade: "Kg"
        },
        {
            nome: 'Chocolate',
            precoEmbalagem: 38.90,
            quantidadeEmbalagem: 500,
            quantidadeUtilizada: 200,
            custo: 15.56,
            id: 3,
            tipo: "sólido",
            unidade: "g"
        },
        {
            nome: 'Leite',
            precoEmbalagem: 4.50,
            quantidadeEmbalagem: 1,
            quantidadeUtilizada: 2,
            custo: 9.0,
            id: 4,
            tipo: "líquido",
            unidade: "L"
        },

    ];

    // const [custoTotal, setCustoTotal] = useState(0.0);

    return (
        <div className="container">
            <p>Custo Total R${CustoTotal(ingredientes).toFixed(2)}</p>
            <table className="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Produto</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Quantidade da embalagem</th>
                        <th scope="col">Preço da embalagem</th>
                        <th scope='col'>Quantidade Utilizada</th>
                        <th scope='col'>Custo</th>
                    </tr>
                </thead>
                <tbody>
                    {ingredientes.map(item => {
                        return (
                            <tr key={item.id}>
                                <th scope="row">{item.id}</th>
                                <td>{item.nome}</td>
                                <td>{item.tipo}</td>
                                <td>{item.quantidadeEmbalagem}{item.unidade}</td>
                                <td>R${item.precoEmbalagem.toFixed(2)}</td>
                                <td>{item.quantidadeUtilizada}{item.unidade}</td>
                                <td>R${item.custo.toFixed(2)}</td>
                            </tr>
                        );
                    })}
                </tbody>
            </table>
        </div>
    )
}