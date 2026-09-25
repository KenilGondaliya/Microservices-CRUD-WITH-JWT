package ejb;

import entity.Garmentmaster;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface GarmentBeanLocal {

    // Create
    void addGarment(Garmentmaster garment);

    // Read all
    List<Garmentmaster> getAllGarments();

    // Read by ID
    Garmentmaster getGarmentById(Integer id);

    // Update
    void updateGarment(Garmentmaster garment);

    // Delete
    void deleteGarment(Integer id);
}