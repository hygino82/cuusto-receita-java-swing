export type Ingrediente = {
  nome: string;
  precoEmbalagem: number;
  quantidadeEmbalagem: number;
  quantidadeUtilizada: number;
  custo: number;
  id: number;
  tipo: "sólido" | "líquido";
  unidade: "Kg" | "g" | "L" | "mL";
};
