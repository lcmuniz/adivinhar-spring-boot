package br.com.lcmuniz.adivinhar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class MainController {

    int numero = new Random().nextInt(100) + 1;
    String mensagem = "";
    int tentativas = 0;
    boolean acertou = false;

    @GetMapping
    public String inicio(Model model) {
        System.out.println(numero);
        model.addAttribute("mensagem", mensagem);
        model.addAttribute("tentativas", tentativas);
        model.addAttribute("acertou", acertou);
        model.addAttribute("formulario", new Formulario());
        return "jogo";
    }

    @PostMapping("/enviar")
    public String enviar(Formulario formulario) {

        int p = Integer.valueOf(formulario.palpite);

        if (p < numero) {
            mensagem = "Palpite muito pequeno";
        }
        else if (p > numero) {
            mensagem = "Palpite muito grande";
        }
        else {
            mensagem = "Você acertou!";
            acertou = true;
        }
        tentativas++;

        return "redirect:/";
    }

}
