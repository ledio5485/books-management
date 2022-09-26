package com.booksmanagement.magazine.api;

import com.booksmanagement.magazine.service.MagazineService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/magazines")
@RequiredArgsConstructor
public class MagazineResource {
    private final MagazineService magazineService;

    @GetMapping
    public List<MagazineDTO> list(
            @RequestParam(value = "sortBy", defaultValue = "title", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        return magazineService.list(sort);
    }

    @GetMapping("/filter")
    public List<MagazineDTO> list(@RequestParam(value = "author") String author) {
        return magazineService.filterBy(author);
    }

    @GetMapping(value = "{isbn}")
    public ResponseEntity<MagazineDTO> getByIsbn(@PathVariable("isbn") @NotNull String isbn) {
        return ResponseEntity.of(magazineService.getByIsbn(isbn));
    }
}
