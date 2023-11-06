package co.cryptogramming.restapi.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import co.cryptogramming.restapi.dto.ProductMapper;
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

    /* Sin uso de MapStruct
    public List<Product> getAllProducts() {
        // Buscar todos los productos de MongoDB
        return repository.findAll();
    }
    */

    // Uso MapStruct
    public List<ProductDTO> getAllProducts() {
        // Déspues de busca en la BD y obtener una lista de productos
        List<Product> products = repository.findAll();

        /**
         * Aplicamos el método stream() para convertir la lista en un flujo de datos
         * pudiendo realizar distintas operaciones, en este caso uso método map()
         * para lograr iterar cada uno de nuestros productos, llamamos la interfaz que tiene
         * el producto maper y llamamos al metodo productToProductDto, convirtiendo el product a productDTO
         * usar el método collect() convierte todo el flujo de datos a una lista
         */
        List<ProductDTO> productDTOS = products.stream().map(
                product -> ProductMapper.mapper.productToProductDto(product)).collect(Collectors.toList());

        return productDTOS;
    }

    // Uso MapStruct
    public void createProduct(ProductDTO productDTO) {
        Product product = ProductMapper.mapper.productDtoToProduct(productDTO);

        product.setDistributor("ACME");
        Date dateNow = new Date();
        product.setReleaseDate(dateNow);

        repository.save(product);
    }

    /*
    Sin uso de MapStruct
    public void createProduct(ProductDTO productDTO) {
        /**
         * Conversión: Recibimos un ProductDTO
         * Creamos un objeto de tipo Product y pasamos al constructor cada uno de los parametros
         * Todo esto para guardar un product, ya que la clase/capa repository necesito un objeto de tipo Product
         * NO un objeto ProductDTO, para poder interactuar con MongoDB
         *
        Product product = new Product(
                productDTO.getId(),
                productDTO.getImagePath(),
                productDTO.getTitle(),
                productDTO.getDescription());

        repository.save(product);
    }
     */


    /**
     * @param productId  id del producto
     * @param productDTO objeto ProductDTO
     * @return
     */
     public ProductDTO updateProduct(int productId, ProductDTO productDTO) {
         /**
          * Buscamos en MongoDB que queremos editar, mediante el parametro productId
          * En caso de no encontrarlo, retornara nulo, pero si lo consigue retorna el producto
          */
         Product product = repository.findById(productId).orElse(null);

         // Si llega el producto le cambiamos los datos, setters
        if (product != null) {
            product.setTitle(productDTO.getTitle());
            product.setDescription(productDTO.getDescription());
            product = repository.save(product);
            //repository.save(product);
        }

         ProductDTO response =   ProductMapper.mapper.productToProductDto(product);

         return response;
     }
     public void deleteProduct(int productId) {
        Product product = repository.findById(productId).orElse(null);

        if (product != null) {
            repository.delete(product);
        }
    }

}