package Relatorios;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controller.Conexao;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class RelatorioGeral 
{
   
    public void gerarPDF() 
    {
        
        Date dataH = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataH);
        String data2 = new SimpleDateFormat("ddMMyyyy").format(dataH);
        
        int contador = 0;
        
        try
        {
            
            //Destino do arquivo
            String nomearquivo = "S:\\NTI\\DIGITALIZADOS\\SEMUR CONTROLE ESTOQUE\\RelatorioGeral"+data2+".pdf";
            
            //Cria documento
            Document documento = new Document();
            
            PdfWriter.getInstance(documento, new FileOutputStream(nomearquivo));
            
            //Seta orientação do documento
            documento.setPageSize(PageSize.A4.rotate());
                    
            documento.open();
                    
            //Cria imagem com caminho para a imagem
            Image imagem = Image.getInstance("S:\\NTI\\Projeto estagio\\SemurrCEI\\src\\view\\imagens\\logopref.png");
                    
            //Seta a altura e largura da imagem
            imagem.scaleAbsolute(97, 87);
            
            //Alinha a imagem ao centro do documento
            imagem.setAlignment(Element.ALIGN_CENTER);
                    
            documento.add(imagem);
                    
            //Cria um paragrafo e alinha ao centro
            Paragraph ptitulo = new Paragraph("SEMUR-NTI", FontFactory.getFont(FontFactory.TIMES_BOLD, 14f));
            ptitulo.setAlignment(Element.ALIGN_CENTER);
            
            documento.add(ptitulo);
            
            //Cria um paragrafo e alinha ao centro
            Paragraph psubtitulo = new Paragraph("| - SISTEMA DE CONTROLE DE EQUIPAMENTOS - |", FontFactory.getFont(FontFactory.TIMES_BOLD, 12f));
            psubtitulo.setAlignment(Element.ALIGN_CENTER);

            documento.add(psubtitulo);      
            
            //Cria um paragrafo e adicona ao documento
            
            Paragraph vazio = new Paragraph(" ", FontFactory.getFont(FontFactory.TIMES_BOLD, 4f));
            
            documento.add(vazio);
                    
            //Cria uma tabela ao documento
            
            PdfPTable tablesup= new PdfPTable(9);
            
            //Cria celula para o titulo da tabela
                    
            PdfPCell CELULATitulo = new PdfPCell(new Paragraph("RELATORIO EQUIPAMENTOS", FontFactory.getFont(FontFactory.TIMES_BOLD, 13f)));
            
            CELULATitulo.setColspan(10);
                    
            CELULATitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                    
            CELULATitulo.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    
            tablesup.addCell(CELULATitulo);
                    

            tablesup.addCell(new Paragraph("UNIDADE", FontFactory.getFont(FontFactory.TIMES_BOLD, 13f)));

            tablesup.addCell(new Paragraph("TIPOEQUIP", FontFactory.getFont(FontFactory.TIMES_BOLD, 13f)));

            tablesup.addCell(new Paragraph("TOMBO", FontFactory.getFont(FontFactory.TIMES_BOLD, 13f)));

            tablesup.addCell(new Paragraph("SERIAL", FontFactory.getFont(FontFactory.TIMES_BOLD, 13f)));

            tablesup.addCell(new Paragraph("FORNECEDOR", FontFactory.getFont(FontFactory.TIMES_BOLD, 13f)));

            tablesup.addCell(new Paragraph("FABRICANTE", FontFactory.getFont(FontFactory.TIMES_BOLD, 13f)));

            tablesup.addCell(new Paragraph("MODELO", FontFactory.getFont(FontFactory.TIMES_BOLD, 13f)));

            tablesup.addCell(new Paragraph("STATUS", FontFactory.getFont(FontFactory.TIMES_BOLD, 13f)));      

            float[] columnWidths = new float[]{23f, 35f, 23f, 23f,35f,34f,28f,34f,35f};
            tablesup.setWidths(columnWidths);    
            
            tablesup.setWidthPercentage(106);
            
            try
            {
                
                Connection conexao = new Conexao().Conectar();
                
                PreparedStatement pstm = null;
                
                ResultSet rs = null;
                
                String sql = "select * from equipamento as e inner join unidade u on e.unidade = u.id inner join tipoequipamento as tp on e.tipoequip = tp.id inner join\n" +
                "fornecedor as f on e.fornecedor = f.id inner join fabricante as fab on e.fabricante = fab.id";     
        
                pstm = conexao.prepareStatement(sql);
        
                rs = pstm.executeQuery();
        
                while(rs.next())
                {
                    
            
                    tablesup.addCell(rs.getString("unidadenome"));
                    tablesup.addCell(rs.getString("tipoequipamentonome"));
                    tablesup.addCell(rs.getString("tombo"));
                    tablesup.addCell(rs.getString("serie"));
                    tablesup.addCell(rs.getString("fornecedornome"));
                    tablesup.addCell(rs.getString("fabricantenome"));
                    tablesup.addCell(rs.getString("modelo"));
                    tablesup.addCell(rs.getString("status"));
                    tablesup.addCell(rs.getString("equipamento"));   
                    
                    contador++;
            
                }                 
                
            }
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao consultar para gerar pdf: " + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
                
            }  
                
            documento.add(tablesup);
                    
            Paragraph pcontador = new Paragraph("QUANTIDADE DE EQUIPAMENTOS: " + contador, FontFactory.getFont(FontFactory.TIMES_ROMAN, 14f));
            pcontador.setAlignment(Element.ALIGN_LEFT);            
            
            documento.add(pcontador);           
                    
            Paragraph pdata = new Paragraph(data, FontFactory.getFont(FontFactory.TIMES_BOLD, 14f));
            pdata.setAlignment(Element.ALIGN_LEFT);
            
            documento.add(pdata);
            
            documento.close();
            
            JOptionPane.showMessageDialog(null, "Relatorio emitido com sucesso!","Relatorio emitido com sucesso!", JOptionPane.INFORMATION_MESSAGE);
                
            }

            catch(DocumentException ex)
             {
                    
                JOptionPane.showMessageDialog(null, "Error ao gerar o documento!" +ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
                    
            }
            catch(FileNotFoundException ex)
            {
                    
                JOptionPane.showMessageDialog(null, "Error ao gerar o documento!" +ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
                    
            } 
            catch(IOException ex)
            {
                    
                JOptionPane.showMessageDialog(null, "Error ao gerar o documento!" +ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
                    
            }          
        
    }
        
}
