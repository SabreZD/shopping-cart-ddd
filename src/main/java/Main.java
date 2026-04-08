import application.service.CartService;
import application.command.AddItemCommand;
import application.event.ItemAddedEvent;
import application.handler.CartCommandHandler;
import application.handler.CartQueryHandler;
import application.query.GetCartTotalQuery;
import domain.factory.CartFactory;
import domain.model.Cart;
import domain.repository.CartRepository;
import infrastructure.InMemoryCartRepository;

public class Main {
    public static void main(String[] args) {
        CartRepository repo = new InMemoryCartRepository();

        CartFactory factory = new CartFactory();
        Cart cart = factory.createCart();
        repo.save(cart);

        CartService service = new CartService(repo);

        // Handlers
        CartCommandHandler commandHandler = new CartCommandHandler(service);
        CartQueryHandler queryHandler = new CartQueryHandler(service);

        // COMMAND
        AddItemCommand cmd =
                new AddItemCommand(cart.getId(), "P1", 2, 50);
        AddItemCommand cmd2 =
                new AddItemCommand(cart.getId(), "P2", 3, 75);

        ItemAddedEvent event = commandHandler.handle(cmd);
        System.out.println("Event: Item added → " + event.productId);
        ItemAddedEvent event2 = commandHandler.handle(cmd2);
        System.out.println("Event: Item added → " + event2.productId);


        // QUERY
        double total = queryHandler.handle(
                new GetCartTotalQuery(cart.getId())
        );

        System.out.println("Cart total: " + total);


//        CartFactory factory = new CartFactory();
//        CartRepository repo = new InMemoryCartRepository();
//
//        Cart cart = factory.createCart();
//        repo.save(cart);
//
//        CartService service = new CartService(repo);
//
//        service.addItem(cart.getId(), "P1", 2, 50);
//        service.addItem(cart.getId(), "P1", 1, 50);
//
//        System.out.println("Total: " + service.getTotal(cart.getId()));
    }
}
