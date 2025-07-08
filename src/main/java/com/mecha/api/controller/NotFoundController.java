package com.mecha.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import com.mecha.api.dto.api.ApiExceptionDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.RequestDispatcher;

@Controller
public class NotFoundController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<ApiExceptionDTO> handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null && Integer.parseInt(status.toString()) == 404) {
            return ResponseEntity.status(404)
                .body(new ApiExceptionDTO("Not found", "The URL requested does not exist"));
        }
        return ResponseEntity.status(500)
            .body(new ApiExceptionDTO("Internal error", "An unexpected error occurred"));
    }
}
