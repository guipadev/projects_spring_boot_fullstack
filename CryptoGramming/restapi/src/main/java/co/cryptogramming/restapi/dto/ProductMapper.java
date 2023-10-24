package co.cryptogramming.restapi.dto;

import co.cryptogramming.restapi.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Se debe usar la anotación, permite al procesador de dicha libreria que se active durante la compilación
 */
@Mapper
public interface ProductMapper {

    /**
     * Tenemos que crear un atributo, en esta caso llamamos mapper de la misma entidad ProductMapper
     * Y llama a la clase Mappers que hace parte de la libreria y obtengamos una instancia de la misma
     *
     */
    ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    /**
     * Métodos que convierten de un tipo de objeto a otro:
     * Definimos el nombre del método que va a retornar
     * En este caso queremos que retorne productDTO y reciba un product
     * Se coloca un Source que es el atributo de Product y el atributo de destino target ProductDTO
     * Mismo atributo pero con un nombre diferente
     * @param product entidad Product
     * @return ProductDTO
     */
    @Mapping(source = "imagePath", target = "imageUrl")
    ProductDTO productToProductDto(Product product);

    /**
     * Este método realiza el inverso recibe un ProductDTO y devuelve un Product
     * @param productDTO entidad ProductDTO
     * @return Product
     */
    @Mapping(source = "imageUrl", target = "imagePath")
    Product productDtoToProduct(ProductDTO productDTO);
}
