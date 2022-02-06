import {Entity, model, property} from '@loopback/repository';

@model()
export class Friendslist extends Entity {
  @property({
    type: 'number',
    id: true,
    generated: false,
    required: true,
  })
  ID1: number;

  @property({
    type: 'number',
    required: true,
  })
  ID2: number;


  constructor(data?: Partial<Friendslist>) {
    super(data);
  }
}

export interface FriendslistRelations {
  // describe navigational properties here
}

export type FriendslistWithRelations = Friendslist & FriendslistRelations;
