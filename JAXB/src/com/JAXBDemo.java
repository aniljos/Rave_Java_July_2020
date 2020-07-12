package com;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.gen.ObjectFactory;
import com.gen.Product;

public class JAXBDemo {

	public static void main(String[] args) {
		
		marshal();
		//unmarshal();
		
		

	}

	private static void unmarshal() {
		
		try {
			
			JAXBContext context = JAXBContext.newInstance(Product.class);
			Unmarshaller  unmarshaller = context.createUnmarshaller();
			Product p = (Product) unmarshaller.unmarshal(new File("product.xml"));
			System.out.println(p.getId());
			System.out.println(p.getName());
			System.out.println(p.getPrice());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void marshal() {
		Product product = new Product();
		product.setId(100);
		product.setName("Apple macbook");
		product.setPrice(80000);
		
		try {
			
			JAXBContext context = JAXBContext.newInstance(Product.class);
			Marshaller marshaller = context.createMarshaller();
			
			ObjectFactory factory = new ObjectFactory();
			JAXBElement<Product> element = factory.createProduct(product);
			marshaller.marshal(element, new File("product.xml"));
			
			//marshaller.marshal(product, new File("product.xml"));
			
			
			System.out.println("Product marshalled to XML");
			
		} catch (JAXBException e) {
			
			e.printStackTrace();
		}
	}

}
