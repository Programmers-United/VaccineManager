package com.br.vaccineManager.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.br.vaccineManager.dao.PatientDAO;
import com.br.vaccineManager.entities.Patient;

public class Main {
	private static int controller;
	private static final Scanner scanner = new Scanner(System.in);
	private static final PatientDAO pacienteDao = new PatientDAO();
	
	//Método para adicionar um paciente
	private static void addPatient () {
		System.out.println("Informe o nome do paciente: ");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("Informe a data de nascimento: ");
		String date = scanner.nextLine();
		System.out.println("Informe o genero do paciente: ");
		String genre = scanner.nextLine();
		System.out.println("Informe o numero de telefone: ");
		String tephone = scanner.nextLine();
		System.out.println("Informe o emeail do paciente: ");
		String email = scanner.nextLine();
		
		Patient paciente = new Patient();
		
		paciente.setName(name);
		paciente.setDataNascimento(date);
		paciente.setGenre(genre);
		paciente.setEmail(email);
		paciente.setNumTelefone(tephone);
		
		pacienteDao.createdPatient(paciente);
	}
	
	//Método para listar dados de um paciente
	private static void listDataPatient () throws SQLException {
		System.out.println("Informe o id do paciente: ");
		int id = scanner.nextInt();
		
		Patient paciente = new Patient();
		paciente = pacienteDao.searchPatient(id);

		System.out.println("====== Dados do Paciente =======");
		System.out.println("Id: " + paciente.getId());
		System.out.println("Name: " + paciente.getName());
		System.out.println("Email: " + paciente.getEmail());
		System.out.println("Nascimento: " + paciente.getDataNascimento());
		System.out.println("Genero: " + paciente.getGenre());
		System.out.println("Telefone: " + paciente.getNumTelefone());
	}
	
	//Méotodo para editar dados de um paciente
	private static void editPatient () {
		System.out.println("Informe o id do paciente: ");
		int id = scanner.nextInt();
		
		System.out.println("Informe o nome do paciente: ");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("Informe a data de nascimento: ");
		String date = scanner.nextLine();
		System.out.println("Informe o genero do paciente: ");
		String genre = scanner.nextLine();
		System.out.println("Informe o numero de telefone: ");
		String tephone = scanner.nextLine();
		System.out.println("Informe o emeail do paciente: ");
		String email = scanner.nextLine();
		
		Patient paciente = new Patient();
		
		paciente.setId(id);
		paciente.setName(name);
		paciente.setDataNascimento(date);
		paciente.setGenre(genre);
		paciente.setEmail(email);
		paciente.setNumTelefone(tephone);
		
		pacienteDao.editPacient(paciente);
	}
	
	//Método para deletar paciente
	private static void deletePatient () {
		System.out.println("Informe o id do paciente: ");
		int id = scanner.nextInt();
		
		pacienteDao.removePatient(id);
	}
	
	//Método para listar os pacientes
	private static void listAllPatients () {
		List<Patient> parcientes = pacienteDao.allPatients();
		
		for (Patient patient : parcientes) {
			System.out.println("Id: " + patient.getId());
			System.out.println("Name: " + patient.getName());
			System.out.println("Email: " + patient.getEmail());
			System.out.println("Nascimento: " + patient.getDataNascimento());
			System.out.println("Genero: " + patient.getGenre());
			System.out.println("Telefone: " + patient.getNumTelefone());
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		
		while (true) {
			
			System.out.println("============= MENU =============");
			System.out.println("1 - Adicionar um novo paciente");
			System.out.println("2 - Listar dados de um paciente");
			System.out.println("3 - Para editar dados de um paciente");
			System.out.println("4 - Para remover um paciente");
			System.out.println("5 - Para listar todos os pacientes");
			System.out.println("0 - Para enecerrar o sistema");
			System.out.println("===============================");
			controller = scanner.nextInt();
			
			switch (controller) {
			case 1:
				 addPatient();
			break;
			
			case 2:
				listDataPatient();
			break;
			
			case 3:
				editPatient();
			break;
		
			case 4:
				deletePatient();
			break;
			
			case 5:
				listAllPatients();
			break;
			
			case 0:
                System.out.println("Encerrando o sistema...");
                System.exit(0); // Encerrar o programa
            break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
			}
		}
		/*//Criando um Paciente
		Patient paciente = new Patient();
		paciente.setName("Diogo");
		paciente.setDataNascimento("26/12/2003");
		paciente.setGenre("Masculino");
		paciente.setNumTelefone("(02) 02040-6091");
		paciente.setEmail("dood@gmail.com");
		paciente.setId(2);
		
		PatientDAO pacienteDao = new PatientDAO();
		pacienteDao.removePatient(2);
		*//*
		System.out.println("Name: " + search.getName());
		System.out.println("Email: " + search.getEmail());
		System.out.println("Nascimento: " + search.getDataNascimento());
		System.out.println("Genero: " + search.getGenre());
		System.out.println("Telefone: " + search.getNumTelefone());
		System.out.println("Id: " + search.getId());*/
		
		
	}
}
