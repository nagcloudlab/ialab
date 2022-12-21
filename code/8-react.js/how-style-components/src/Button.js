import styled, { css } from "styled-components"


const Button = styled.a`
  display: inline-block;
  border-radius: 3px;
  padding: 0.5rem 0;
  margin: 0.5rem 1rem;
  width: 11rem;
  background: tomato;
  color: black;
  border: 2px solid white;
  border-radius: 3px;
  text-decoration: none;
  text-align: center;

  ${props => props.p && css`
  background: red;
  color: black;
`}

`


export default Button;