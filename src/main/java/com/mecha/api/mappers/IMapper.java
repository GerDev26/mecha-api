package com.mecha.api.mappers;

public interface IMapper<Request, Response, Entity> {
    Entity RequestToEntity(Request request);
    Response EntityToResponse(Entity entity);
}
