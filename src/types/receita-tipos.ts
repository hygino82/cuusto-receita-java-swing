export type Ingrediente = {
    nome: string;
    descricao?: string;
    precoEmbalagem: number;
    quantidadeEmbalagem: number;
    quantidadeUtilizada: number;
    unidadeEmbalagem: 'L' | 'ML' | 'G' | 'KG';
    unidadeUtilizada: 'L' | 'ML' | 'G' | 'KG';
}