import test1.MapHandler;
import test3.Counter;
import test3.model.Cart;
import test3.model.Customer;
import test3.model.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

public class ExcerciseRunner {

    public static void main(String[] args) {

        System.out.println("================ exercise 1 ==================");
        MapHandler mapHandler = new MapHandler();
        String text = "key1=value1;key2=value2\nkeyA=valueA\n";
        System.out.println("load text : ");
        System.out.print(text);
        System.out.println("");

        Map[] result = mapHandler.load(text);
        System.out.println("result : " + Arrays.toString(result));

        System.out.println("");
        System.out.println("store array of map : " + Arrays.toString(result));
        System.out.println("result : ");
        String textResult = mapHandler.store(result);
        System.out.println(textResult);


        System.out.println("================ exercise 2 ==================");
        Customer customer = new Customer("mr awesome", false, true, 1);
        Cart cart = new Cart(customer);
        cart.addProduct(new Product(true, BigDecimal.valueOf(75)));
        cart.addProduct(new Product(false, BigDecimal.valueOf(85)));
        cart.addProduct(new Product(false, BigDecimal.valueOf(135)));

        System.out.println("generate build for cart :");
        System.out.println(cart.toString());

        Counter counter = new Counter();
        BigDecimal bill = counter.checkout(cart);

        System.out.println("Billing :" + bill);

    }


}
