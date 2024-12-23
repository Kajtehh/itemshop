package pl.kajteh.itemshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kajteh.itemshop.model.Product;
import pl.kajteh.itemshop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProductService implements CommonService<Product, UUID> {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public void delete(UUID id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> get(UUID id) {
        return this.productRepository.findById(id);
    }

    public List<Product> getAll(UUID serverId) {
        return this.productRepository.findAllByServerId(serverId);
    }
}
