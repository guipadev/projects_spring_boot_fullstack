package cp.report;

import net.sf.jasperreports.engine.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class JasperReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(JasperReportApplication.class, args);
	}

	/**
	 * Se ejecute todo el codigo aquí, inmediatamente se levante la App
	 * @return
	 */
	@Bean
	CommandLineRunner init() {
		return args -> {
			// Definir ruta donde quedara el reporte, ruta para cualquer OS
			String destinationPath = "src" + File.separator +
					"main" + File.separator +
					"resources" + File.separator +
					"static" + File.separator +
					"ReportGenerated.pdf";

			// Ruta jxrml para generar el reporte
			String filePath = "src" + File.separator +
					"main" + File.separator +
					"resources" + File.separator +
					"templates" + File.separator +
					"reportJasper" + File.separator +
					"Report.jrxml";

			// Fecha y hora actual
			LocalDateTime localDateTime = LocalDateTime.now();
			// Formateo de fecha
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

			// Envío parametros para el reporte
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("voucher_id", "0000451255");
			// Envío fecha actual formateada
			parameters.put("current_date", formatter.format(localDateTime));
			parameters.put("AmountPaid", new BigDecimal("30000"));
			parameters.put("payment_method", "Efectivo");
			parameters.put("parent_name", "Jose Omar Rivera Perez");
			parameters.put("child_name", "Andrea Rivera Torres");
			// Parametro adicional del directorio de la imagenes
			parameters.put("imageDir", "classpath:/static/images/");

			// Generación de Reporte, le enviamos el reporte que tenemos
			JasperReport report = JasperCompileManager.compileReport(filePath);
			// Llenar reporte, al no utilizar BD colocamos new JREmpty...
			JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
			JasperExportManager.exportReportToPdfFile(print, destinationPath);

			System.out.println("Report Created Successfully");
		};
	}
}
