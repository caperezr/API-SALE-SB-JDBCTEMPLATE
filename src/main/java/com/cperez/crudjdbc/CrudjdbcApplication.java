package com.cperez.crudjdbc;

import com.cperez.crudjdbc.tables.StoredProcedure;
import com.cperez.crudjdbc.tables.TableCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CrudjdbcApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(CrudjdbcApplication.class, args);
		// Obtener un objeto JdbcTemplate de la aplicación context
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

		// Crear una instancia de TableCreator y llamar al método crearTablaUsuarios()
		TableCreator tableCreator = new TableCreator(jdbcTemplate);
		tableCreator.crearTablaCient();
		tableCreator.crearTablaSale();
		tableCreator.crearTablaProduct();
		tableCreator.crearTablaSaleDetail();
		//Crear los procedimientos
		StoredProcedure procedureCreator = new StoredProcedure(jdbcTemplate);
		procedureCreator.procedureGetClients();
		procedureCreator.procedureGetClientById();
		procedureCreator.procedureCreateClient();
		procedureCreator.procedureGetProducts();
		procedureCreator.procedureGetProcutById();
		procedureCreator.procedureCreateProduct();
		procedureCreator.procedureGetSaleDetailByIdSale();
		procedureCreator.procedureCreateSaleDetail();
		//procedureCreator.triggerMaxId();

	}

}
