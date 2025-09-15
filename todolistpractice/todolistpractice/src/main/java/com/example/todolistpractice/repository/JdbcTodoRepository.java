package com.example.todolistpractice.repository;

/*import com.example.todolistpractice.domain.Todo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;


public class JdbcTodoRepository implements TodoRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTodoRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Todo save(Todo todo) {
        String sql = "INSERT INTO todo (content, completed) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, todo.getContent());
            ps.setBoolean(2, todo.isCompleted());
            return ps;
        }, keyHolder);

        // 생성된 ID를 받아와 Todo 객체에 설정
        Number key = keyHolder.getKey();
        if (key != null) {
            todo.setId(key.longValue());
        }
        return todo;
    }

    @Override
    public Optional<Todo> findById(Long id) {
        List<Todo> result = jdbcTemplate.query("SELECT * FROM todo WHERE id = ?", todoRowMapper(), id);
        return result.stream().findFirst();
    }

    @Override
    public List<Todo> findAll() {
        return jdbcTemplate.query("SELECT * FROM todo", todoRowMapper());
    }

    @Override
    public void update(Long id, Todo todo) {
        String sql = "UPDATE todo SET content = ?, completed = ? WHERE id = ?";
        jdbcTemplate.update(sql, todo.getContent(), todo.isCompleted(), id);
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM todo WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private RowMapper<Todo> todoRowMapper() {
        return (rs, rowNum) -> {
            Todo todo = new Todo();
            todo.setId(rs.getLong("id"));
            todo.setContent(rs.getString("content"));
            todo.setCompleted(rs.getBoolean("completed"));
            return todo;
        };
    }
}


 */