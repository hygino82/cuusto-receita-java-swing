import { Ingrediente } from "../types/receita-tipos";

export function CustoTotal(ingredientes: Ingrediente[]) {
  let soma: number = 0.0;
  ingredientes.forEach((item) => (soma += item.custo));
  
  return soma;
}
