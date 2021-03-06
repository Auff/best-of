package com.victorsalaun.bestof.ws.command

import com.victorsalaun.bestof.ws.domain.BestOf
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
class BestOfCommandController @Autowired constructor(
        private val bestOfCommandService: BestOfCommandService
) {

    private val logger = LoggerFactory.getLogger(BestOfCommandController::class.java)

    @RequestMapping(
            value = "/bestof",
            method = arrayOf(RequestMethod.POST),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    private fun create(@RequestBody bestOf: BestOf): BestOf {
        logger.info("Received data for new " + bestOf.toString())
        return bestOfCommandService.create(bestOf)
    }

    @RequestMapping(
            value = "/bestof",
            method = arrayOf(RequestMethod.PUT),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    private fun update(@RequestBody bestOf: BestOf): BestOf {
        logger.info("Received data for updating " + bestOf.toString())
        return bestOfCommandService.update(bestOf)
    }

    @RequestMapping(
            value = "/bestof/{id}",
            method = arrayOf(RequestMethod.DELETE),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    private fun delete(@PathVariable id: String) {
        logger.info("Deleting BestOf #" + id)
        bestOfCommandService.delete(id)
    }

}
