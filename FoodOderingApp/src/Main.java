import com.javatraining.exceptions.DuplicateAddressException;
import com.javatraining.exceptions.NoEntriesException;
import com.javatraining.exceptions.NoEntryException;
import com.javatraining.model.Address;
import com.javatraining.service.AddressBookImpl;

/**
 *
 */
public class Main {
    public static void main(String[] args) {

        AddressBookImpl addressImpl = new AddressBookImpl();

        try {
            Address address1 = new Address(101, "John", "Doe", 123456);
            addressImpl.addAddress(address1);

            Address address2 = new Address(202, "Jane", "Smith", 654321);
            addressImpl.addAddress(address2);

            addressImpl.removeAddress("John");
            addressImpl.removeAddress("Alice");
            System.out.println(addressImpl.getAllAddressEntries());
        } catch (NullPointerException | NoEntriesException | NoEntryException |
                 DuplicateAddressException e) {
            System.out.println(e.getMessage());
        }
    }
}