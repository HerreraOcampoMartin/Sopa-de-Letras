
package pkg05.sopa.de.letras;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Panel extends JPanel{
    public Panel(){
        
        setLayout(new BorderLayout());
        
        principal = new Principal();
        menu = new MenuP();
        palabra = new Palabras();
  
        principal.crearEtiquetas();
        palabra.crearPalabras();
        principal.escribirPalabras();
        
        add(principal, BorderLayout.CENTER);
        add(menu, BorderLayout.NORTH);
        add(palabra, BorderLayout.EAST);
        
    }
    
    Palabras palabra;
    MenuP menu;
    Principal principal;
    Font fuente1 = new Font("Script MT Bold", Font.BOLD, 12);
    
     class Principal extends JPanel{
        public Principal(){
            setLayout(new GridLayout(20,20));
            
            setBackground(Ventana.fondo1);
        } 
        
            boolean eligiendo = false;
        public void crearEtiquetas(){
            int x = 0, y = 0;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    JLabel aux = new JLabel(Datos.getLetraRandom());
                    aux.setLocation(x, y);
                    aux.setName("L");
                    aux.setForeground(Ventana.fore1);
                    aux.setHorizontalAlignment(SwingConstants.CENTER);
                    aux.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent me) {
                        }
                        @Override
                        public void mousePressed(MouseEvent me) {
                         if(!aux.getName().equals("M")){
                            aux.setBorder(miBorde);
                            aux.setName("M");
                            eligiendo = true;
                            lista.add(aux);
                            }else{
                                aux.setName("L");
                                aux.setBorder(BorderFactory.createEmptyBorder());
                            }
                        }
                        @Override
                        public void mouseReleased(MouseEvent me) {
                            eligiendo = false;
                            boolean p = false;
                            String listaA = "";
                            String listaB = "";
                            for (int m = 0; m < lista.size(); m++) {
                                listaA += lista.get(m).getText();
                            }
                            for (int m = lista.size()-1; m > -1; m--) {
                                listaB += lista.get(m).getText();
                            }
                            for (int k = 0; k < 10; k++) {        
                                if(listaA.equals(palabras.get(k))){
                                    if(palabrasL[k].getFont() != fuente1){
                                    p = true;
                                    }
                                }
                                if(p){
                                    palabrasL[k].setFont(fuente1);
                                    completadas++;
                                    if(completadas == 10){
                                        Ventana v = new Ventana();
                                        v.setVisible(true);
                                    }
                                    for (int l = 0; l < lista.size(); l++) {
                                        lista.get(l).setEnabled(false);
                                        lista.get(l).setBorder(null);
                                    }
                                    break;
                                }
                                
                            }
                            if(!p){
                                for (int k = 0; k < 10; k++) {        
                                if(listaB.equals(palabras.get(k))){
                                    if(palabrasL[k].getFont() != fuente1){
                                    p = true;
                                    }
                                }
                                if(p){
                                    palabrasL[k].setFont(fuente1);
                                    completadas++;
                                    if(completadas == 10){
                                        Ventana v = new Ventana();
                                        v.setVisible(true);
                                    }
                                    for (int l = 0; l < lista.size(); l++) {
                                        lista.get(l).setEnabled(false);
                                        lista.get(l).setBorder(null);
                                    }
                                    break;
                                }
                                
                            }
                                if(!p){    
                                    for (int l = 0; l < lista.size(); l++) {
                                    lista.get(l).setBorder(null);
                                    lista.get(l).setName("L");
                                    }
                                }
                            }
                            lista.clear();
                            
                        }
                        @Override
                        public void mouseEntered(MouseEvent me) {
                            if(!eligiendo){
                                if(!aux.isEnabled()){
                           
                                }else if(aux.getBorder() == null)
                                aux.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            }else{
                                aux.setBorder(miBorde);
                                aux.setName("M");
                                lista.add(aux);
                            }
                        }
                        @Override
                        public void mouseExited(MouseEvent me) {
                            if(!aux.getName().equals("M")){
                            aux.setBorder(null);
                            }else if(!aux.isEnabled()){
                            aux.setBorder(null); 
                            }
                        }
                    });
                    letras[i][j] = aux;
                    add(aux);
                    x += 20;
                }
                x = 0;
                y += 20;
            }            
        }
        
        
        public void escribirPalabras(){
            
            int casillasEscritasX[] = new int[20];
            int casillasEscritasY[] = new int[20];
            String dir;
            
            for (int i = 0; i < 10; i++) {
                
                dir = getDireccion();
                
                try{
                 Random aleatorio = new Random();
                 int x, y;
                 
                 casillasEscritasX = new int[20];
                 casillasEscritasY = new int[20];
                 
                 x = aleatorio.nextInt(19);
                 y = aleatorio.nextInt(19);
           
                    switch (dir) {
                        case "vertical":
                            for (int j = 0; j < palabras.get(i).length(); j++) {
                                if(letras[x+j][y].getName().equals("O")){
                                throw new CasillaOcupadaException();
                                }else{
                                letras[x+j][y].setText(String.valueOf(palabras.get(i).charAt(j)));
                                letras[x+j][y].setName("O");
                                casillasEscritasX[j] = x; 
                                casillasEscritasY[j] = y; 
                                }
                            }                       
                            break;
                        case "horizontal":
                            for (int j = 0; j < palabras.get(i).length(); j++) {
                                if(letras[x][y+j].getName().equals("O")){
                                throw new CasillaOcupadaException();
                                }else{
                                letras[x][y+j].setText(String.valueOf(palabras.get(i).charAt(j)));
                                letras[x][y+j].setName("O");
                                casillasEscritasX[j] = x; 
                                casillasEscritasY[j] = y;
                                }
                            }
                            break;
                        
                    }
                    
                }catch(ArrayIndexOutOfBoundsException ex){
                 i--;   
                 for (int j = 0; j < casillasEscritasX.length; j++) {
                     switch(dir){
                         case "horizontal":
                         letras[casillasEscritasX[j]][casillasEscritasY[j]].setName("L");
                         break;
                         case "vertical":
                         letras[casillasEscritasX[j]][casillasEscritasY[j]].setName("L");
                         break;
                     }
                 }
                }catch(CasillaOcupadaException ex){
                 i--;
                 for (int j = 0; j < casillasEscritasX.length; j++) {
                     switch(dir){
                         case "horizontal":
                         letras[casillasEscritasX[j]][casillasEscritasY[j]].setName("L");
                         break;
                         case "vertical":
                         letras[casillasEscritasX[j]][casillasEscritasY[j]].setName("L");
                         break;
                     }
                 }
                }
            }
            
            
            
        }
        
        public String getDireccion(){
            String dir = "";
            Random r = new Random();
            int d;
            
            d = r.nextInt(2);
            
            switch (d) {
                case 0:
                    dir = "horizontal";
                    break;
                case 1:
                    dir = "vertical";
                    break;
            }
            
            return dir;
        }
        
    }
    class MenuP extends JPanel{
        public MenuP(){
            setLayout(new BorderLayout());

            setBackground(Color.BLACK);
            
            JMenuBar barraMenu = new JMenuBar();
            JMenu menu1 = new JMenu("Ventana");
            JMenu menu3 = new JMenu("Estilos");
            JMenuItem menui1 = new JMenuItem("Crear nueva ventana");
            JMenuItem menui2 = new JMenuItem("Cambiar fondo de 'Palabras'");
            JMenuItem menui4 = new JMenuItem("Cambiar fondo de 'Sopa de Letras'");
            JMenuItem menui5 = new JMenuItem("Cambiar letra de 'Sopa de Letras'");
            JMenuItem menui6 = new JMenuItem("Cambiar letra de 'Palabras'");
            
            menui1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Ventana v = new Ventana();
                    v.setVisible(true);
                }
            });
            menui2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Ventana.fondo2 = JColorChooser.showDialog(Panel.this, "Color a elegir", Ventana.fondo2);
                    palabra.setBackground(Ventana.fondo2);
                }
            });
            menui4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Ventana.fondo1 = JColorChooser.showDialog(Panel.this, "Elegir Color", Ventana.fondo1);
                    principal.setBackground(Ventana.fondo1);
                }
            });
            menui5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Ventana.fore1 = JColorChooser.showDialog(Panel.this, "Elegir Color", Ventana.fore1);
                    for (int i = 0; i < 20; i++) {
                        for (int j = 0; j < 20; j++) {
                            letras[i][j].setForeground(Ventana.fore1);
                            if(letras[i][j].getBorder() != null){
                                letras[i][j].setBorder(BorderFactory.createLineBorder(Ventana.fore1));
                            }
                        }
                    }
                }
            });
            menui6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Ventana.fore2 = JColorChooser.showDialog(Panel.this, "Elegir Color", Ventana.fore2);
                    for (int i = 0; i < 10; i++) {
                        palabrasL[i].setForeground(Ventana.fore2);
                    }
                }
            });
            
            menu1.add(menui1);
            menu3.add(menui4);
            menu3.add(menui5);
            menu3.add(menui2);
            menu3.add(menui6);
            //barraMenu.add(menu2);
            barraMenu.add(menu3);
            barraMenu.add(menu1);
            add(barraMenu, BorderLayout.CENTER);
            
        }
    }
    Border miBorde = BorderFactory.createLineBorder(Ventana.fore1);
    int completadas = 0;
    ArrayList <JLabel> lista = new ArrayList<>();
    
    class Palabras extends JPanel{
        public Palabras(){
            setBorder(LineBorder.createBlackLineBorder());
            setBackground(Ventana.fondo2);
            setLayout(new GridLayout(11, 1)); 
            
            JLabel p = new JLabel("    Palabras:    ");
            p.setForeground(Ventana.fore2);
            p.setBorder(new LineBorder(Ventana.fore2));
            p.setFont(new Font("Verdana", 3, 18));
            add(p);
            
        }
        
        public void crearPalabras(){            
            
            palabras = Datos.getPalabraRandom();
            for (int i = 0; i < 10; i++) {
                JLabel aux = new JLabel();
                aux.setText(palabras.get(i));
                aux.setBorder(new LineBorder(Ventana.fore2));
                aux.setBackground(Color.GREEN);
                aux.setForeground(Ventana.fore2);
                aux.setHorizontalAlignment(SwingConstants.CENTER);
                aux.setFont(new Font("Verdana", Font.ITALIC, 16));
                palabrasL[i] = aux; 
                add(aux);
            }
        }
        
    }
    
    private JLabel [][] letras = new JLabel[20][20];
    private JLabel [] palabrasL = new JLabel[10];
    private ArrayList <String> palabras = new ArrayList<>();
    
}
class CasillaOcupadaException extends java.io.IOException{
    public CasillaOcupadaException(){
        super();
    }
}
