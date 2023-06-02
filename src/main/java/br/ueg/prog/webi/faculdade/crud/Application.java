package br.ueg.prog.webi.faculdade.crud;

import br.ueg.prog.webi.faculdade.crud.model.Carro;
import br.ueg.prog.webi.faculdade.crud.repository.CarroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CarroRepository carroRepository){
		return args -> {
			System.out.println("Teste");
			Carro carro = new Carro();
			carro.setPlaca("abc1234");
			carro.setAno(2020);
			carro.setCor("preto");
			carro.setModelo("nivus");
			carro.setQuilometragem(0l);
			carro.setStatus("Disponível");
			carro = carroRepository.save(carro);
			Optional<Carro>c1 = carroRepository.findByModelo(carro.getModelo());
			System.out.println("carro1: "+ c1);
		};
	}
}
