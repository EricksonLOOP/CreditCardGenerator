package org.edev.Gerador;

import java.util.Random;

public class Gerador {
    public void Gerar() {
        String card = "";
        boolean gerar = true;

        while (gerar) {
            Random random = new Random();
            String BIN = "549580";

            // Adiciona 3 partes ao BIN
            for (int i = 0; i <= 2; i++) {
                int newNum;
                if (i == 0) {
                    newNum = 10 + random.nextInt(90); // dois dígitos
                } else {
                    newNum = 1000 + random.nextInt(9000); // quatro dígitos
                }
                BIN += newNum;
            }

            card = BIN;
            if (verificadorDeLuhn(card)) {
                gerar = false;
                System.out.println("Cartão Válido: " + card);
            } else {
                System.out.println("Não válido: " + card);
            }
        }
    }

    public boolean verificadorDeLuhn(String card) {
        int total = 0;
        for (int i = 0; i < card.length(); i++) {
            int num = Character.getNumericValue(card.charAt(card.length() - 1 - i));

            // Dobra o valor a cada segundo dígito (a partir do penúltimo)
            if (i % 2 == 1) {
                num *= 2;
                if (num > 9) {
                    num -= 9; // Se o número dobrado for maior que 9, subtrai 9
                }
            }
            total += num; // Adiciona o valor ao total
        }

        return total % 10 == 0; // Verifica se o total é múltiplo de 10
    }

}
