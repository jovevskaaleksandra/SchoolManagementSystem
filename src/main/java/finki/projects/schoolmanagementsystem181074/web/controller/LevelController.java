package finki.projects.schoolmanagementsystem181074.web.controller;

import finki.projects.schoolmanagementsystem181074.model.Level;
import finki.projects.schoolmanagementsystem181074.model.exceptions.LevelNotFoundException;
import finki.projects.schoolmanagementsystem181074.service.LevelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/level")
public class LevelController {

    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @GetMapping("/dashboard")
    public String levelIndex(Model model) {
        model.addAttribute("level", new Level());
        model.addAttribute("levels", levelService.findAll());
        return "level/dashboard";
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Level getLevel (@PathVariable(value = "id") Integer id)
            throws LevelNotFoundException {
        Level s = levelService.findById(id)
                .orElseThrow(() -> new LevelNotFoundException());
        return s;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Level> getAllLevels() {
        return levelService.findAll();
    }

    @PostMapping("/create")
    public String createLevel(@ModelAttribute Level s) {
        levelService.save(s);
        return "redirect:dashboard";
    }

    @GetMapping(path="/{id}/edit")
    public String viewUpdateFormLevel(@PathVariable(value = "id") Integer id,
                                      Model model) throws LevelNotFoundException {
        model.addAttribute("level", this.getLevel(id));
        return "level/edit";
    }

    @PutMapping("/{id}/update")
    public String updateLevel(@ModelAttribute Level s) {
        levelService.save(s);
        return "redirect:/level/dashboard";
    }

    @DeleteMapping("/delete")
    public String deleteLevel(@ModelAttribute Level s) {
        levelService.delete(s);
        return "redirect:dashboard";
    }
}