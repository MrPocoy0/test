package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Config;
import services.ConfigService;

@RestController
@RequestMapping("/api/config")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @GetMapping
    public List<Config> getAllConfigs() {
        return configService.getAllConfigs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Config> getConfigById(@PathVariable Long id) {
        Config config = configService.getConfigById(id)
                .orElseThrow(() -> new RuntimeException("Config not found with id " + id));
        return ResponseEntity.ok(config);
    }

    @PostMapping
    public Config createConfig(@RequestBody Config config) {
        return configService.createConfig(config);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Config> updateConfig(@PathVariable Long id, @RequestBody Config configDetails) {
        Config updatedConfig = configService.updateConfig(id, configDetails);
        return ResponseEntity.ok(updatedConfig);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConfig(@PathVariable Long id) {
        configService.deleteConfig(id);
        return ResponseEntity.noContent().build();
    }
}
