package com.uploadarquivosapirest.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Disco {

	@Value("${disco.raiz}")
	private String raiz;
	
	@Value("${disco.diretorio-file}")
	private String diretorioFile;
	
	public void salvarFile(MultipartFile file) {
		this.salvar(this.diretorioFile, file);
	}

	private void salvar(String diretorio, MultipartFile arquivo) {
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());
		
		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());
		} catch (IOException e) {
			throw new RuntimeException("Problemas na tentativa de salvar o arquivo");
		}
	}
}
