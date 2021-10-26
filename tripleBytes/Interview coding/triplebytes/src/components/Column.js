import React, { Component } from 'react';

export default class Column extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: this.props.person.id,
      name: this.props.person.name,
      color: this.props.person.color,
      todos: this.props.person.todos // []
    };
  }

  genrateTodos = () => {
    return this.state.todos.map(todo => {
      return (
        <div className="todo_item">
          <span>{todo}</span>
        </div>
      );
    });
  };

  handleInputClick(ev) {
    window.prompt();
    let value = ev.target.value;
    this.props.handleAddTodo(this.state.id, value);
  }

  render() {
    return (
      <div className="column_container">
        <div
          className="person_title"
          style={{ backgroundColor: this.state.color }}
        >
          <span>{this.state.name}</span>
        </div>
        <div className="todo_body">{this.genrateTodos()}</div>
        <div className="todo_addTodo">
          <input></input>
        </div>
      </div>
    );
  }
}
