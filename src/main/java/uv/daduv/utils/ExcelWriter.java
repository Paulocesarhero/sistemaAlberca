package uv.daduv.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import uv.daduv.domain.Deportista;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class ExcelWriter {
    public static void guardarDeportistaEnExcel(Deportista deportista, String nombreArchivo) throws IOException {
        FileInputStream fis = null;
        Workbook workbook = null;

        try {
            fis = new FileInputStream(nombreArchivo);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            // El archivo no existe, crea uno nuevo
            workbook = new XSSFWorkbook();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

        // Obtén la hoja existente o crea una nueva
        Sheet sheet = workbook.getSheet("Deportistas");
        if (sheet == null) {
            sheet = workbook.createSheet("Deportistas");
            // Crear encabezados solo si la hoja es nueva
            Row headerRow = sheet.createRow(0);
            String[] headers = {"ID", "Nombre", "Tipo", "Modalidad", "Edad", "Teléfono", "No de Credencial", "Horario", "Sexo", "Correo"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }
        }

        // Obtén el número de la siguiente fila disponible
        int rowNum = sheet.getLastRowNum() + 1;
        Row deportistaRow = sheet.createRow(rowNum);

        // Llenar los datos del deportista en las celdas
        deportistaRow.createCell(0).setCellValue(deportista.getId());
        deportistaRow.createCell(1).setCellValue(deportista.getNombre());
        deportistaRow.createCell(2).setCellValue(deportista.getTipo());
        deportistaRow.createCell(3).setCellValue(deportista.getModalidad());
        deportistaRow.createCell(4).setCellValue(deportista.getEdad());
        deportistaRow.createCell(5).setCellValue(deportista.getTelefono());
        deportistaRow.createCell(6).setCellValue(deportista.getNoCredencial());
        deportistaRow.createCell(7).setCellValue(deportista.getHorario());
        deportistaRow.createCell(8).setCellValue(deportista.getSexo());
        deportistaRow.createCell(9).setCellValue(deportista.getCorreo());

        // Guardar el libro en el mismo archivo
        try (FileOutputStream outputStream = new FileOutputStream(nombreArchivo)) {
            workbook.write(outputStream);
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }
    }
}
