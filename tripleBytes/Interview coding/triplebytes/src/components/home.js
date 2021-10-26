import React, { Component } from 'react';
import Column from './Column';

export default class home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      people: [
        {
          id: 0,
          name: 'Tommy',
          color: '#8E6E95',
          todos: ['shopping', 'studying']
        },
        {
          id: 1,
          name: 'Bob',
          color: '#39A59C',
          todos: ['shopping', 'studying']
        },
        {
          id: 2,
          name: 'Thomas',
          color: '#344759',
          todos: ['shopping', 'studying']
        },
        {
          id: 3,
          name: 'George',
          color: '#E8741E',
          todos: ['shopping', 'studying']
        }
      ]
    };
  }

  generateCols() {
    return this.state.people.map((person, index) => {
      return (
        <Column
          key={index}
          person={person}
          handleAddTodo={this.handleAddTodo}
        />
      );
    });
  }

  handleAddTodo(id, value) {
    // update state, set
    let newPeople = this.state.people.map(person => {
      if (person.id === id) {
        let newTodos = [...person.todos, value];
        person.todos = newTodos;
        return person;
      }
    });

    this.state.people.setState(newPeople);
  }

  render() {
    return <div className="container">{this.generateCols()}</div>;
  }
}
