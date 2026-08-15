/*package edu.infosys.FarmVerseApplication.repository;

public interface CropInputsRepository {
}*/

package edu.infosys.FarmVerseApplication.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.infosys.FarmVerseApplication.entity.CropInputs;
public interface CropInputsRepository extends JpaRepository<CropInputs, String> {
}
