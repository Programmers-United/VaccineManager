package com.br.vaccineManager.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.br.vaccineManager.dao.PatientDAO;
import com.br.vaccineManager.dao.VaccinatioDAO;
import com.br.vaccineManager.entities.Patient;
import com.br.vaccineManager.entities.Vaccination;

public class Main {
	private static int controller;
	private static final Scanner scanner = new Scanner(System.in);
	private static final PatientDAO pacienteDao = new PatientDAO();
	private static final VaccinatioDAO vaccinationDao = new VaccinatioDAO();
	
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
		System.out.println("Informe o email do paciente: ");
		String email = scanner.nextLine();
		
		Patient paciente = new Patient();
		
		paciente.setName(name);
		paciente.setDataNascimento(date);
		paciente.setGenre(genre);
		paciente.setEmail(email);
		paciente.setNumTelefone(tephone);
		
		pacienteDao.createdPatient(paciente);
	}
	
	//Método para adicionar uma Vacinacao
	private static void addVaccination () {
		System.out.println("Informe o nome da Vacina : ");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("Informe a data de vacinacao: ");
		String date = scanner.nextLine();
		System.out.println("Informe o lote da vacina: ");
		String lote = scanner.nextLine();
		System.out.println("Informe o nome do medico: ");
		String medico = scanner.nextLine();
		System.out.println("Informe o id do paciente: ");
		int idPaciente = scanner.nextInt();
		
		if (pacienteDao.patientExists(idPaciente)) {
			Vaccination vacinacao = new Vaccination();
			
			vacinacao.setNomeVaccine(name);
			vacinacao.setData(date);
			vacinacao.setLote(lote);
			vacinacao.setMedico(medico);
			vacinacao.setIdPaciente(idPaciente);
			
			vaccinationDao.createdVaccination(vacinacao);			
		} else {
			System.out.println("Usuario nao encontrado ou nao existe");
		}
	}
	
	//Método para listar dados de um paciente
	private static void listDataPatient () throws SQLException {
		System.out.println("Informe o id do paciente: ");
		int id = scanner.nextInt();
		
		Patient paciente = new Patient();
		paciente = pacienteDao.searchPatient(id);

		if (paciente.getId() != 0 ) {			
			System.out.println("====== Dados do Paciente =======");
			System.out.println("Id: " + paciente.getId());
			System.out.println("Name: " + paciente.getName());
			System.out.println("Email: " + paciente.getEmail());
			System.out.println("Nascimento: " + paciente.getDataNascimento());
			System.out.println("Genero: " + paciente.getGenre());
			System.out.println("Telefone: " + paciente.getNumTelefone());
		}
	}

	//Método para listar dados de uma vacinacao
	private static void listDataVaccination () throws SQLException {
		System.out.println("Informe o id da Vacinacao: ");
		int id = scanner.nextInt();
		
		Vaccination vacinacao = new Vaccination();
		vacinacao = vaccinationDao.searchVaccination(id);

		if (vacinacao.getId() != 0) {
			System.out.println("====== Dados do Vacinacao =======");
			System.out.println("Id: " + vacinacao.getId());
			System.out.println("Vacina: " + vacinacao.getNomeVaccine());
			System.out.println("Lote: " + vacinacao.getLote());
			System.out.println("Data: " + vacinacao.getData());
			System.out.println("Medico: " + vacinacao.getMedico());
			System.out.println("Id do Paciente: " + vacinacao.getIdPaciente());			
		}
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
	
	//Méotodo para editar dados de um paciente
	private static void editVaccination() {
		System.out.println("Informe o id da vacinacao: ");
		int id = scanner.nextInt();
		
		System.out.println("Informe o nome da Vacina : ");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("Informe a data de vacinacao: ");
		String date = scanner.nextLine();
		System.out.println("Informe o lote da vacina: ");
		String lote = scanner.nextLine();
		System.out.println("Informe o nome do medico: ");
		String medico = scanner.nextLine();
		System.out.println("Informe o id do paciente: ");
		int idPaciente = scanner.nextInt();
		
		if (pacienteDao.patientExists(idPaciente)) {
			Vaccination vacinacao = new Vaccination();
			
			vacinacao.setId(id);
			vacinacao.setNomeVaccine(name);
			vacinacao.setData(date);
			vacinacao.setLote(lote);
			vacinacao.setMedico(medico);
			vacinacao.setIdPaciente(idPaciente);
			
			vaccinationDao.editVaccination(vacinacao);			
		} else {
			System.out.println("Usario nao existe ou nao econtrado");
		}
	}
	
	//Método para deletar paciente
	private static void deletePatient () {
		System.out.println("Informe o id do paciente: ");
		int id = scanner.nextInt();
		
		pacienteDao.removePatient(id);
	}

	//Método para deletar vacinacao
	private static void deleteVaccination () {
		System.out.println("Informe o id da vacinacao: ");
		int id = scanner.nextInt();
		
		vaccinationDao.removePatient(id);
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

	//Método para listar os pacientes
	private static void listAllVaccinations () {
		List<Vaccination> vacinacoes = vaccinationDao.allVaccinations();
		
		for (Vaccination vaccination : vacinacoes) {
			System.out.println("Id: " + vaccination.getId());
			System.out.println("Vacina: " + vaccination.getNomeVaccine());
			System.out.println("Lote: " + vaccination.getLote());
			System.out.println("Data: " + vaccination.getData());
			System.out.println("Medico: " + vaccination.getMedico());
			System.out.println("Id do Paciente: " + vaccination.getIdPaciente());
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		
		while (true) {
			
			System.out.println("===================== MENU =====================");
			System.out.println("1 - Adicionar um novo paciente");
			System.out.println("2 - Listar dados de um paciente");
			System.out.println("3 - Para editar dados de um paciente");
			System.out.println("4 - Para remover um paciente");
			System.out.println("5 - Para listar todos os pacientes");
			System.out.println("6 - Adicionar um novo registro de vacinacao");
			System.out.println("7 - Listar dados de um registro de vacinacao");
			System.out.println("8 - Para editar dados de um registro de vacinacao");
			System.out.println("9 - Para remover um registro de vacinacao");
			System.out.println("10 - Para listar todas os registros de vacinacoes");
			System.out.println("0 - Para enecerrar o sistema");
			System.out.println("==================================================");
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
			
			case 6:
				addVaccination();
			break;
			
			case 7:
				listDataVaccination();
			break;
			
			case 8:
				editVaccination();
			break;
		
			case 9:
				deleteVaccination();
			break;
			
			case 10:
				listAllVaccinations();
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
