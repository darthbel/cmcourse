package com.felipebelgine.cmcourse;

import com.felipebelgine.cmcourse.domain.*;
import com.felipebelgine.cmcourse.enums.ClientType;
import com.felipebelgine.cmcourse.enums.PaymentStatus;
import com.felipebelgine.cmcourse.repositories.*;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class CmcourseApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;



    public static void main(String[] args) {
        SpringApplication.run(CmcourseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "IT");
        Category cat2 = new Category(null, "Office");

        Product p1 = new Product(null, "Computer", 2000.00);
        Product p2 = new Product(null, "Printer", 800.00);
        Product p3 = new Product(null, "Mouse", 80.00);

        cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProducts().addAll(Arrays.asList(p2));

        p1.getCategories().addAll((Arrays.asList(cat1)));
        p2.getCategories().addAll(Arrays.asList(cat1, cat2));
        p3.getCategories().addAll(Arrays.asList(cat1));

        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        State est1 = new State(null, "Minas Gerais");
        State est2 = new State(null, "Sao Paulo");

        City c1 = new City(null, "Uberlandia", est1);
        City c2 = new City(null, "Sao Paulo", est2);
        City c3 = new City(null, "Campinas", est2);

        est1.getCities().addAll(Arrays.asList(c1));
        est2.getCities().addAll(Arrays.asList(c2, c3));

        stateRepository.saveAll(Arrays.asList(est1, est2));
        cityRepository.saveAll(Arrays.asList(c1, c2, c3));

        Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.NATURALPERSON);
        cli1.getPhoneNumbers().addAll(Arrays.asList("27363323", "93838393"));

        Address e1 = new Address(null, "300", "Rua Flores", "Apt 203", "38220834", cli1, c1);
        Address e2 = new Address(null, "105", "Avenida Matos", "Room 800", "38777012", cli1, c2);

        cli1.getAddresses().addAll(Arrays.asList(e1, e2));

        clientRepository.saveAll(Arrays.asList(cli1));
        addressRepository.saveAll(Arrays.asList(e1, e2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        PurchaseOrder ped1 = new PurchaseOrder(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
        PurchaseOrder ped2 = new PurchaseOrder(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

        Payment pagto1 = new PaymentCard(null, PaymentStatus.DONE, ped1, 6);
        ped1.setPayment(pagto1);

        Payment pagto2 = new PaymentSlip(null, PaymentStatus.PENDING, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPayment(pagto2);

        cli1.getPurchaseOrders().addAll(Arrays.asList(ped1, ped2));

        purchaseOrderRepository.saveAll(Arrays.asList(ped1, ped2));
        paymentRepository.saveAll(Arrays.asList(pagto1, pagto2));

        OrderItem ip1 = new OrderItem(ped1, p1, 0.00, 1, 2000.00);
        OrderItem ip2 = new OrderItem(ped1, p3, 0.00, 2, 80.00);
        OrderItem ip3 = new OrderItem(ped2, p2, 100.00, 1, 800.00);

        ped1.getItems().addAll(Arrays.asList(ip1, ip2));
        ped2.getItems().addAll(Arrays.asList(ip3));

        p1.getItems().addAll(Arrays.asList(ip1));
        p2.getItems().addAll(Arrays.asList(ip3));
        p3.getItems().addAll(Arrays.asList(ip2));

        orderItemRepository.saveAll(Arrays.asList(ip1, ip2, ip3));


    }
}

