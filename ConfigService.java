package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Config;
import repositories.ConfigRepository;

@Service
public class ConfigService {

    @Autowired
    private ConfigRepository configRepository;

    public List<Config> getAllConfigs() {
        return configRepository.findAll();
    }

    public Optional<Config> getConfigById(Long id) {
        return configRepository.findById(id);
    }

    public Config createConfig(Config config) {
        return configRepository.save(config);
    }

    public Config updateConfig(Long id, Config configDetails) {
        Config config = configRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Config not found with id " + id));

        config.setKey(configDetails.getKey());
        config.setValue(configDetails.getValue());

        return configRepository.save(config);
    }

    public void deleteConfig(Long id) {
        Config config = configRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Config not found with id " + id));

        configRepository.delete(config);
    }
}
