package co.cryptogramming.restapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.cryptogramming.restapi.domain.Product;
import co.cryptogramming.restapi.dto.ProductDTO;
//import co.cryptogramming.domain.Product;
//import co.cryptogramming.domain.model.CrudService;
import co.cryptogramming.restapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService /* implements CrudService<Product> */ {

    // Inyectamos el repository
    private final ProductRepository repository;

    public List<Product> getAllProducts() {
        // Buscar todos los productos de MongoDB
        return repository.findAll();
    }

    /**
     *
     * @param productDTO objeto tipo ProductDTO
     */
    public void createProduct(ProductDTO productDTO) {
        /**
         * Conversión: Recibimos un ProductDTO
         * Creamos un objeto de tipo Product y pasamos al constructor cada uno de los parametros
         * Todo esto para guardar un product, ya que la clase/capa repository necesito un objeto de tipo Product
         * NO un objeto ProductDTO, para poder interactuar con MongoDB
         */
        Product product = new Product(
                productDTO.getId(),
                productDTO.getImagePath(),
                productDTO.getTitle(),
                productDTO.getDescription());

        repository.save(product);
    }


    /**
     * @param productId id del producto
     * @param productDTO objeto ProductDTO
     */
     public void updateProduct(int productId, ProductDTO productDTO) {
         /**
          * Buscamos en MongoDB que queremos editar, mediante el parametro productId
          * En caso de no encontrarlo, retornara nulo, pero si lo consigue retorna el producto
          */
         Product product = repository.findById(productId).orElse(null);

         // Si llega el producto le cambiamos los datos, setters
        if (product != null) {
            product.setTitle(productDTO.getTitle());
            product.setDescription(productDTO.getDescription());

            repository.save(product);
        }
     }
     public void deleteProduct(int productId) {
        Product product = repository.findById(productId).orElse(null);

        if (product != null) {
            repository.delete(product);
        }
    }

}