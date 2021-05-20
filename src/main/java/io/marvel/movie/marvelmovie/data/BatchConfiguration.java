package io.marvel.movie.marvelmovie.data;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import io.marvel.movie.marvelmovie.model.Movie;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    private static String[] FIELD_DATA = { "id", "title", "phase", "genres", "release_date", "director",
            "screen_writer", "producer", "cast", "language", "filming_locations", "status", "movie_rating",
            "review_rating", "movie_run_time", "budget", "box_office" };

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<MovieInput> reader() {
        return new FlatFileItemReaderBuilder<MovieInput>().name("personItemReader")
                .resource(new ClassPathResource("MCU_movies_Dataset.csv")).delimited().names(FIELD_DATA)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MovieInput>() {
                    {
                        setTargetType(MovieInput.class);
                    }
                }).build();
    }

    @Bean
    public MovieProcessor processor() {
        return new MovieProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Movie> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Movie>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO movie (id, title, genres, release_date, director, screen_writer, producer, cast, language, filming_locations, status, movie_rating, review_rating ,movie_run_time, budget, box_office) VALUES (:id, :title, :genres, :releaseDate, :director, :screenWriter, :producer, :cast, :language, :filmingLocations, :status, :movieRating, :reviewRating, :movieRunTime, :budget, :boxOffice)")
                .dataSource(dataSource).build();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener).flow(step1)
                .end().build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Movie> writer) {
        return stepBuilderFactory.get("step1").<MovieInput, Movie>chunk(10).reader(reader()).processor(processor())
                .writer(writer).build();
    }

}
