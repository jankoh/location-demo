package de.n4.locationdemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import software.amazon.awssdk.services.location.LocationClient
import software.amazon.awssdk.services.location.model.SearchPlaceIndexForTextRequest
import software.amazon.awssdk.services.location.model.SearchPlaceIndexForTextResponse

@RestController
@RequestMapping("api/geo")
class DemoController {

    @GetMapping
    fun getLocation(): List<String> {
        val result: SearchPlaceIndexForTextResponse? = LocationClient.builder().build().searchPlaceIndexForText(
            SearchPlaceIndexForTextRequest.builder()
                .apply {
                    maxResults(10)
                    indexName("explore.place")
                    text("Leipzig")
                    filterCountries("DEU")
                }
                .build()
        )

        return if (result == null || !result.hasResults()) {
            listOf()
        } else {
            result.results().map { searchForTextResult ->
                searchForTextResult.place().label()
            }
        }
    }
}