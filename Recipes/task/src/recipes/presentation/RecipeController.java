package recipes.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.business.Recipe;
import recipes.business.RecipeService;
import recipes.business.User;
import recipes.business.UserService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class RecipeController {
    @Autowired
    RecipeService recipeService;
    @Autowired
    UserService userService;


    @PostMapping("/api/recipe/new")
    public Map<String, Long> postRecipe(@Valid @RequestBody Recipe recipe, @AuthenticationPrincipal UserDetails details) {
        String username = details.getUsername();
        String password = details.getPassword();
        User user = new User();
        user.setEmail(username);
        user.setPassword(password);

        recipe.setUser(user);
        Recipe recipeCreated = recipeService.save(recipe);
        return Map.of("id", recipeCreated.getId());
    }

    @GetMapping("/api/recipe/{id}")
    public Recipe getRecipe(@PathVariable long id) {

        Recipe recipe = recipeService.findRecipeById(id);
        if (recipe == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return recipe;
    }

    @DeleteMapping("/api/recipe/{id}")
    public void deleteRecipe(@PathVariable long id, @AuthenticationPrincipal UserDetails details) {
        String username = details.getUsername();
        String password = details.getPassword();
        User user = new User();
        user.setEmail(username);
        user.setPassword(password);

        Recipe recipe = recipeService.findRecipeById(id);
        if (recipe == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        recipe = recipeService.findRecipeByIdAndUser(id, user);
        if (recipe == null) throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        recipeService.deleteRecipeById(id);

        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/api/recipe/{id}")
    public void updateRecipe(@PathVariable long id, @Valid @RequestBody Recipe recipe, @AuthenticationPrincipal UserDetails details) {
        String username = details.getUsername();
        String password = details.getPassword();
        User user = new User();
        user.setEmail(username);
        user.setPassword(password);

        Recipe prev = recipeService.findRecipeById(id);
        if (prev == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        prev = recipeService.findRecipeByIdAndUser(id, user);
        if (prev == null) throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        recipe.setDate(LocalDateTime.now());
        recipe.setId(id);
        recipe.setUser(user);
        recipeService.save(recipe);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/api/recipe/search")
    public ResponseEntity<List<Recipe>> searchRecipe(@RequestParam(required = false) @Valid String name, @RequestParam(required = false) @Valid String category) {
        if (name == null && category == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        if (name != null && category != null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        if (name != null) return new ResponseEntity<>(recipeService.searchByName(name), HttpStatus.OK);
        else return new ResponseEntity<>(recipeService.searchByCategory(category), HttpStatus.OK);

    }

    @PostMapping("/api/register")
    public void register(@Valid @RequestBody User user) {

        userService.save(user);
    }
}
