package recipes.persistance;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import recipes.business.Recipe;
import recipes.business.User;

import java.util.List;


@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

   Recipe findRecipeById(Long id);
   Recipe findRecipeByIdAndUser(Long id, User user);
   void deleteById(Long id);
   List<Recipe> findAllByNameContainingIgnoreCaseOrderByDateDesc(String name);

   List<Recipe> findAllByCategoryIgnoreCaseOrderByDateDesc(String category);

}
