package kg.manas.library.converters;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ModelConverter<ModelType, EntityType> {
    private final Function<ModelType, EntityType> fromModel;
    private final Function<EntityType, ModelType> fromEntity;

    public ModelConverter(final Function<ModelType, EntityType> fromModel, final Function<EntityType, ModelType> fromEntity) {
        this.fromModel = fromModel;
        this.fromEntity = fromEntity;
    }

    public final EntityType convertFromModel(final ModelType model) {
        return fromModel.apply(model);
    }

    public final ModelType convertFromEntity(final EntityType entity) {
        return fromEntity.apply(entity);
    }

    public final List<EntityType> createFromModels(final Collection<ModelType> models) {
        if (models == null) return Collections.emptyList();
        return models.stream().map(this::convertFromModel).collect(Collectors.toList());
    }

    public final List<ModelType> createFromEntities(final Collection<EntityType> entities) {
        if (entities == null) return Collections.emptyList();
        return entities.stream().map(this::convertFromEntity).collect(Collectors.toList());
    }

}

