package paquetetpn7;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Compras {

	public static void main(String[] args) { 
		//instanciar a la clase Producto
		
			Producto p1 = new Producto(100,"Dulce","Repostero x 500grs.",450.30,1000);
			Producto p2 = new Producto(101,"Leche","En polvo x 500grs.",200,1000);
			Producto p3 = new Producto(102,"Pan","Casero x 500grs.",150.30,500);
			Producto p4 = new Producto(103,"Café","Frasco x 500grs.",450.30,1000);
			Producto p5 = new Producto(100,"Arroz","Repostero x 500grs.",450.30,1000);
			Producto p6 = new Producto(101,"Fideo","En polvo x 500grs.",200,1000);
			Producto p7 = new Producto(102,"Te","Casero x 500grs.",150.30,500);
			Producto p8 = new Producto(103,"Cacao","Frasco x 500grs.",450.30,1000);
			

			Cliente c1 = new Cliente(180,41645480,"Cano Sebastian", "Las Heras 617");
			
			Carrito carro = new Carrito(25,c1);

			ItemCarrito itemC1 = new ItemCarrito(carro,p1,1);
			ItemCarrito itemC2 = new ItemCarrito(carro,p2,2);
			ItemCarrito itemC3 = new ItemCarrito(carro,p3,3);
			ItemCarrito itemC4 = new ItemCarrito(carro,p4,4);
			ItemCarrito itemC5 = new ItemCarrito(carro,p5,2);	
			ItemCarrito itemC6 = new ItemCarrito(carro,p6,1);
			ItemCarrito itemC7 = new ItemCarrito(carro,p7,3);	
			ItemCarrito itemC8 = new ItemCarrito(carro,p8,2);	
			
			List<ItemCarrito> itemL;
			itemL= new ArrayList<ItemCarrito>();
			
			itemL.add(itemC1);
			itemL.add(itemC2);
			itemL.add(itemC3);
			itemL.add(itemC4);
			itemL.add(itemC5);
			itemL.add(itemC6);
			itemL.add(itemC7);
			itemL.add(itemC8);
			
			Iterator<ItemCarrito> itL = itemL.iterator();
			double total=0;
			itemC4.mostrarTitulo();
			while (itL.hasNext()) {
				ItemCarrito datosI = itL.next();
				datosI.mostrarItems();
				total = total + datosI.dameMontoItem();
			}
			mostrarItems(total, carro, c1);
		}
		
		public static void mostrarItems(double total, Carrito carro, Cliente c1) {
			

			
			carro.mostrarMontoTotal(total);	
			
			 final double montoMin = 5000; 
			 LocalDate dia = LocalDate.now();

		     int descuento = dia.getDayOfMonth();
		     if (descuento %2!=0) {
			 Descuento descFijo=new DescuentoFijo();
			 descFijo.asignaValorDesc(250);//asigno monto fijo que queiro descontar
			 System.out.println("El monto total a pagar con descuento es: "+ descFijo.valorFinal(total));
		     }
		     else {
			Descuento descPorc = new DescuentoPorcentaje();
			if (total<montoMin) {
				descPorc.asignaValorDesc(0.05);
			}
			else
			descPorc.asignaValorDesc(0.10);
			System.out.println("El monto total a pagar con descuento es: "+ descPorc.valorFinal(total));
		     }
			
		}
	}
